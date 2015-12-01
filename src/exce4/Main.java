/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;


import static exce4.Language.arrayBinarioDecimal;
import static exce4.Language.double_toWord;
import java.sql.SQLException;
/**
 *
 * @author Inadaptado
 */

public class Main 
 {
   
    private static final String FILENAME="MEMORY";
    
    public static void main ( final String args[] ) throws SQLException
    {  
       
    /* 
        WordNormalizer IADiccinary=new WordNormalizer();
        
        IADiccinary.loadWords(500,"select * from exce.palabras where 'id'<500");
        IADiccinary.loadMemory(FILENAME);
        IADiccinary.entrenar(0.001);
        IADiccinary.testear();
        IADiccinary.saveMemory(FILENAME);
        IADiccinary.cerrar();
       /*         
        Generador test= new Generador();
        test.entrenar(0.000001);
        test.testear();
        test.cerrar();
     /*
        Generador test= new Generador();
        test.cargarArchivo("C:\\AppServ\\www\\new\\develop\\res\\exce 0.4\\saludos.txt"," - Lina Maria:"," - Jhordy Ar: ");
        test.entrenar(0.000001);        
        test.testear();
        test.cerrar();
        
        */
        Data d= new Data("C:\\AppServ\\www\\new\\develop\\res\\exce 0.4\\saludos.txt"," - Lina Maria:"," - Jhordy Ar: ");
        
        double[][] u=d.getOutputs();
        double[][] t=d.getInputs();
         for(int i=0;i<u.length;i++)
        {    
            System.out.println("User: "+double_toWord(arrayBinarioDecimal(t[i])));
            System.out.println("Exce: "+double_toWord(arrayBinarioDecimal(u[i])));            
        }    
        
    }
}
    