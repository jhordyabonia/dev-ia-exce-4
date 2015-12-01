/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import static exce4.Language.completar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inadaptado
 */
public class Data 
{
    File archivo;
    boolean buffering = true;
    double [][] inputs=new double[10][350];//numero exacto de msj con lina 7694
    double [][] outputs=new double[10][350];
    int length=0;
    String in,out,buffer;
    public Data(String source,String in,String out)
    {
        buffer="";
        this.in=in;
        this.out=out;
        try {
            muestraContenido(source);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void hacerInfoUsable(String data)
    {       
          if(length>=inputs.length)return;
          int pivot=0;
          int start=data.indexOf(in);
          int end=data.indexOf(out);
          if(start>end)
          { int tmp=start; start=end; end=tmp; pivot=1; buffering=!buffering;}
          end=end>data.length()? data.length()-1 : end;
          end=end<0? 0 : end;
          if(pivot==1)
          {
             ///User
             buffer+=data.substring(end).replace(in, "");
             // System.out.println(data.substring(end).replace(in, "User: "));
          }
          else 
          {
              //Exce
              buffer+=data.substring(end).replace(out, "");
              //System.out.println(data.substring(end).replace(out, "Exce: "));             
          }
          
          if(!buffering)
          {
              if(pivot==1)
                  inputs[length]=completar(buffer.toUpperCase());
              else
                  outputs[length]=completar(buffer.toUpperCase());
              
              buffer="";
              length++;
          }
             
    }
    private void  muestraContenido(String archivo) throws FileNotFoundException, IOException 
    {
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) 
      { hacerInfoUsable(cadena); }
      b.close();
    }
    public double[][] getInputs()
    {
        return inputs;        
    } 
    public double[][] getOutputs()
    {
        return outputs;        
    }
    
}
