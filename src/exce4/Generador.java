/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import static exce4.Language.completar;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;

/**
 *
 * @author Inadaptado
 */
public class Generador extends Core
{
    
    @Override
    public BasicNetwork make()
    {
       BasicNetwork network_tmp = new BasicNetwork();
        network_tmp.addLayer(new BasicLayer(null,true,350));//INICIO
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,100));//1
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,100));//2
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,100));//3
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,100));//4
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,100));//5
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,300));//6
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,600));//7
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,600));//8
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,450));//9
      //  network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,450));//0
        network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),false,350));//FIN
        network_tmp.getStructure().finalizeStructure();
        network_tmp.reset() ;
        return network_tmp;
    }    

    @Override
    protected double[][] setInput() 
    {      
     double out[][] = {completar("HOLA"),completar("COMO ESTAS"), 
        completar("COMO TE LLAMAS"), completar("QUIEN ES TU DIOS Y SALVADOR"),
        completar("QUIEN TE CREO")} ;
     return out;
    }   

    @Override
    protected double[][] setOutput() 
    {
        double out[][]= {completar("HOLA"),completar("MUY BIEN GRACIAS A DIOS Y USTED"),completar("EXCE"),
        completar("CRISTO JESUS"),completar("JHORDY")}; 
        return out;
    }
   
}
