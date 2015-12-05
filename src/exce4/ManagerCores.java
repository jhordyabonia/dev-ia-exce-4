/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inadaptado
 */ 
public class ManagerCores extends ArrayList
{
    private ArrayList names =new ArrayList();
    private final String name_file;
    public ManagerCores(String name)
    {
        name_file=name;
    }
    public String getName(int index)
    {
        return (String)names.get(index);
    }
    @Override
    public boolean add(Object o)
    {return this.add("",o);}
    
    @Override
    public Object remove(int index)
    {
        names.remove(index);
        Object out= super.remove(index);
        try {this.guardar();}
        catch (IOException ex) 
        {
            Logger.getLogger(ManagerCores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return out;
    }
    public boolean add(String name,Object o)
    {
        names.add(name);
        return super.add(o);
    }
    public void cargar()throws FileNotFoundException, IOException 
    {        
      String cadena;
      FileReader f = new FileReader(name_file);
        try (BufferedReader b = new BufferedReader(f))
        {
            while((cadena = b.readLine())!=null)
            { this.add(cadena,Core.load(cadena)); }
        }
        f.close();
    }
    public void guardar() throws IOException
    {
        FileWriter f= new FileWriter(name_file);
        for(Object s:names)
        {
            f.write((String)s);
            f.write('\n');
            f.flush();
        }
        f.close();
    }
    
}
