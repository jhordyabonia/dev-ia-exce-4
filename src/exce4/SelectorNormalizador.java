/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.encog.neural.networks.BasicNetwork;

/**
 *
 * @author Inadaptado
 */
public class SelectorNormalizador
{
    ArrayList outs=new ArrayList();
    private int index_out=0;
    private double points_out=0;
    private final ArrayList manager;
    private final ArrayList names_manager;
    private String name_file="";
    private String currentIn="";
    
    SelectorNormalizador(String in) throws FileNotFoundException, IOException
    {
        name_file=in;
        manager = new ArrayList();
        names_manager = new ArrayList();
              
        String cadena;
        FileReader f = new FileReader(name_file);
        BufferedReader b = new BufferedReader(f);
        WordNormalizer IADiccinary=new WordNormalizer();
        
              
        while((cadena = b.readLine())!=null)
        { 
            IADiccinary.loadMemory(cadena);
            names_manager.add(cadena);
            manager.add(IADiccinary);
        }
         f.close();
        //try {this.manager.cargar();} catch (IOException ex)
        //{ Logger.getLogger(SelectorNormalizador.class.getName()).log(Level.SEVERE, null, ex);}
    }    
    public void test_all()
    {
        String FILENAME="A_";
        
                for(int i=0,t=0;i<1603;i+=500,t++)
        {
        WordNormalizer IADiccinary=(WordNormalizer)manager.get(t);
        String sql="select * from exce.palabras2 where `id`> "+i+" and `id`<"+(i+500);
            try {
                IADiccinary.loadWords(500,sql);
            } catch (SQLException ex) {
                Logger.getLogger(SelectorNormalizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //IADiccinary.loadMemory(FILENAME+i);
        //IADiccinary.entrenar(0.054);
        IADiccinary.testear();
        //IADiccinary.saveMemory(FILENAME+i);
        //IADiccinary.usar("EXIT");
        //IADiccinary.cerrar();
        //break;
        }
    }
    public void pasar(String s)
    {
        currentIn=s;
        for(int t=0;t<manager.size();t++)
        {
            WordNormalizer IADiccinary=(WordNormalizer)manager.get(t);
            String tmp=IADiccinary.usar_(s);
            outs.add(tmp);
            //System.out.println(":>"+names_manager.get(t));
            //System.out.println("-"+tmp);
            //System.out.println("#"+s);
        }
    }
    public String getOut()
    {
        for(int i=0;i<outs.size();i++)
        {
            double t=currentIn.compareTo((String ) outs.get(i)); 
            cercano_a_cero(i,t);
            if(points_out==0)
                break;
        }
        String out=(String)outs.get(index_out);
        outs.clear();
        return out;
    }
    private  void cercano_a_cero(int index,double points)
    {
            if(points<0)
                points*=-1;
            
            if(points<points_out)
            {
                points_out=points;
                index_out=index;
            }
    }

         
    public String text(String in)
    {
        String[] words=in.split(" ");
        String out="";
        System.out.println(in);
        for(int v=0;v<words.length;v++)
        {
            
            pasar(words[v].toUpperCase());
            out+=getOut()+" ";
        }
        System.out.println(out);
        return out.substring(0, out.length()-1);
    }
}
