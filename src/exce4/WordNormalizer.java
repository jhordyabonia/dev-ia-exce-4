/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import static exce4.Language.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;

/**
 *
 * @author Inadaptado
 */
public class WordNormalizer extends Core
{        
    private double[][] WORDS;
    private  double[][] IDs;
    
    public  WordNormalizer (){super();}
    public  WordNormalizer (BasicNetwork t)
    {
        super(t);
    }

    public void loadWords(int size,String sql) throws SQLException
    {
        WORDS = new double[size*3][140] ;
        IDs = new double[size*3][15] ;
        ConnectionExce conn=new ConnectionExce();
        if(conn.connect(null, null, null))
            conn.query(sql);
        ResultSet r = conn.lastResult();
        int length=0;
        while(r.next()&&length<size*3)
        {
            String p = r.getString("palabra");
            String p1=error1(p);
            String p2=error2(p);
            String p3=error3(p);
            int i=r.getInt("id");
            WORDS[length]=completar(eliminar_puntuacion(p1).toUpperCase());
            IDs[length]=decimalBinario(i,15);
            WORDS[length++]=completar(eliminar_puntuacion(p2).toUpperCase());
            IDs[length]=decimalBinario(i,15);
            WORDS[length++]=completar(eliminar_puntuacion(p3).toUpperCase());
            IDs[length]=decimalBinario(i,15);
            System.out.println(p1+" "+p2+" "+p3);
            
            length++;
        }
        INPUT=WORDS;
        OUTPUT=IDs;          
        sizeOut = OUTPUT==null? 0:OUTPUT[0].length;  
        trainingSet = new BasicMLDataSet (INPUT, OUTPUT);
    }
    @Override
    protected BasicNetwork make()
    {
        BasicNetwork network_tmp = new BasicNetwork();
        network_tmp.addLayer(new BasicLayer(null,true,140));//INICIO
        network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,210));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,100));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,210));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,420));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,210));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),false,140));
        network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),false,15));//FIN
        network_tmp.getStructure().finalizeStructure();
        network_tmp.reset() ;
        return network_tmp;
    }
       
    @Override
    protected double[][] setInput()
    {
      return WORDS;
    }

    @Override
    protected double[][] setOutput() 
    {
      return IDs;
    }
       
    @Override
     public String usar_(String t)
    {
        double[][] in_pre={completar(t)};
        BasicMLDataSet in=new BasicMLDataSet (in_pre, in_pre);
         for (MLDataPair pair:in )
         {
            ConnectionExce conn=new ConnectionExce();
            String sql="select palabra from exce.palabras2 where `palabra` LIKE \""+t+'"';
            if(!conn.connect(null, null, null))
                //return "*"+t;
                return t;
            
            conn.query(sql);
        
            ResultSet r = conn.lastResult();
            try {
                if(r.next())
                    return r.getString("palabra");
                } 
            catch (SQLException ex) {/*return t+"#";*/ return "";  }
            final MLData output = network.compute(pair.getInput());
            double tmp[]=new double[sizeOut];
            for(int u=0;u<sizeOut;u++)
            {
                tmp[u]=output.getData(u);
            }
            DecimalFormat df = new DecimalFormat("#.#");
            int aux;
            aux = (int)Math.round(Language.binarioDecimal(tmp));
            
            //System.out.println(Language.binarioDecimal(tmp));
            sql="select palabra from exce.palabras2 where `id`="+aux;
            if(conn.connected())
                conn.query(sql);
        
            r = conn.lastResult();
            
            try {
                if(r.next())
                    return r.getString("palabra");
                } 
            catch (SQLException ex) {/*return t+"#";*/ return t;   }         
         }
         //return "*"+t;
         return "";
    }
    @Override
    public void usar(String stop)
    {
        Scanner teclado = new Scanner(System.in);
        String cadena="";
        while(!cadena.equals(stop))
        {
            cadena =teclado.nextLine();
            System.out.println("Exce:> "+usar_(cadena));
                        
        }
    }
    @Override
    public void testear()
    {
    System.out.println("Neural Network Results:");
    for (MLDataPair pair:trainingSet ) 
    {
        final MLData output = network.compute(pair.getInput());
        //System.out.println(pair.getInput().getData(0)+ ", "+pair.getInput().getData(1)+ ", actual="+output.getData(0)+",ideal="+pair.getIdeal().getData(0));
        double tmp[]=new double[sizeOut];
        System.out.println();
        for(int u=0;u<sizeOut;u++)
        {
            tmp[u]=output.getData(u);
            //System.out.print(output.getData(u));
        }
        System.out.println((int)Math.round(Language.binarioDecimal(tmp)));
        //System.out.println(double_toWord(unNormaliceDecimal(tmp)));
    }
    }
}
