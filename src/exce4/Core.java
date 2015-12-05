/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import static exce4.Language.arrayBinarioDecimal;
import static exce4.Language.completar;
import static exce4.Language.double_toWord;
import java.io.File;
import java.util.Scanner;
import org.encog.Encog;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.persist.EncogDirectoryPersistence;

/**
 *
 * @author Inadaptado
 */
public abstract class Core 
{
    protected BasicNetwork network;
    protected BasicMLDataSet trainingSet;
    protected ResilientPropagation train;
    protected double[][]INPUT;
    protected double[][]OUTPUT;
    protected int sizeOut;
    
    public Core()
    {
        network = make();
        INPUT = setInput();
        OUTPUT = setOutput();
        sizeOut = OUTPUT==null? 0:OUTPUT[0].length;
    }
    public void cargarArchivo(String source,String in,String out)
    {
        Data data_tmp=new Data(source,in,out);
        INPUT=data_tmp.getInputs();
        OUTPUT=data_tmp.getOutputs(); 
        sizeOut = OUTPUT==null? 0:OUTPUT[0].length;  
    }
    public final void saveMemory(String FILENAME) 
    {  
        EncogDirectoryPersistence.saveObject(new File(FILENAME) , network); 
    }
    public final void loadMemory(String FILENAME) 
    { 
      network = (BasicNetwork)EncogDirectoryPersistence .loadObject( new File(FILENAME)); 
    }
    public final static Core load(String FILENAME) 
    { 
       Core tmp= new Core() {

           @Override
           protected BasicNetwork make()
           {  return (BasicNetwork)EncogDirectoryPersistence .loadObject( new File(FILENAME));  }

           @Override
           protected double[][] setInput() {return null;}

           @Override
           protected double[][] setOutput() {return null;}
       };
        return tmp;
    }
    public void entrenar(double minErr)
    {
     trainingSet = new BasicMLDataSet (INPUT, OUTPUT);
    
    train = new ResilientPropagation(network,trainingSet);
    int epoch = 1;
    do 
    {
        train.iteration() ;
        System.out.println("Epoch # "+epoch+" Error: "+train.getError( ) ) ;
        epoch++;
    } while (train.getError()>minErr);
    train.finishTraining();
    }
    public void testear()
    {
    System.out.println("Neural Network Results:");
    for (MLDataPair pair:trainingSet ) 
    {
        final MLData output = network.compute(pair.getInput());
        //System.out.println(pair.getInput().getData(0)+ ", "+pair.getInput().getData(1)+ ", actual="+output.getData(0)+",ideal="+pair.getIdeal().getData(0));
        double tmp[]=new double[sizeOut];
        for(int u=0;u<sizeOut;u++)
        {
            tmp[u]=output.getData(u);
        }
        System.out.println(double_toWord(arrayBinarioDecimal(tmp)));
        //System.out.println(double_toWord(unNormaliceDecimal(tmp)));
    }
    }
    public void usar_(String t)
    {
        System.out.println("Exce responce:");
        double[][] in_pre={completar(t)};
        BasicMLDataSet in=new BasicMLDataSet (in_pre, in_pre);
         for (MLDataPair pair:in )
         {
            final MLData output = network.compute(pair.getInput());
            double tmp[]=new double[sizeOut];
            for(int u=0;u<sizeOut;u++)
            {
                tmp[u]=output.getData(u);
            }
            System.out.println(":> "+double_toWord(arrayBinarioDecimal(tmp)));
         }
    }
    public void usar(String stop)
    {
        Scanner teclado = new Scanner(System.in);
        String cadena="";
        while(!cadena.equals(stop))
        {
            cadena =teclado.nextLine();
            usar_(cadena);            
        }
    }
    public void cerrar()
    {
        Encog.getInstance().shutdown();
    }

    protected abstract BasicNetwork make();
    protected abstract  double[][] setInput();
    protected abstract  double[][] setOutput();
    
}
