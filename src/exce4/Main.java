/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;


import java.io.IOException;
import java.sql.SQLException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main 
 {
    private static  String FILENAME="A_";
    
    public static void main ( final String args[] ) throws SQLException, MalformedURLException, IOException
    {   
        //Data d=new Data();
        //d.insertar_archivo("palabras.txt");
        //d.insertar_archivo("Libros Txt/Albert Einstein - Mis Creencias.txt");
        //d.insertar_archivo("Libros Txt/ARISTOTELES LA METAFISICA.txt");
        //d.insertar_archivo("Libros Txt/Bram Stoker - Dracula.txt");
        //d.insertar_archivo("Libros Txt/C. S. Lewis - Las Crónicas de Narnia 1 - El León, la Bruja y el Ropero.txt");
        //d.insertar_archivo("Libros Txt/Caricias de horror - S KING.txt");
        //d.insertar_archivo("Libros Txt/EL ANTICRISTO.txt");
        //d.insertar_archivo("Libros Txt/el corazón condenado - barker.txt");
        //d.insertar_archivo("Libros Txt/EL NACIMIENTO DE LA TRAGEDIA.txt");
        //d.insertar_archivo("Libros Txt/George R. R. Martin - Canción de Hielo y Fuego 1 - Juego de Tronos.txt");
        //d.insertar_archivo("Libros Txt/William Shakespeare - A Buen Fin no Hay Mal Principio.txt");
        
      /*
        SelectorNormalizador t =new SelectorNormalizador("Normalizadores_de_palabras.txt");
        t.test_all();
        
        Scanner teclado = new Scanner(System.in);
        String cadena="";
        while(!cadena.equals("EXIT"))
        {
            cadena =teclado.nextLine();
            t.pasar(cadena.toUpperCase());
            System.out.println(t.getOut());
        }
        for(int i=0;i<14934;i+=500)
        {
        WordNormalizer IADiccinary=new WordNormalizer();
        String sql="select * from exce.palabras2 where `id`> "+i+" and `id`<"+(i+500);
        IADiccinary.loadWords(500,sql);
        
        //IADiccinary.loadMemory(FILENAME+i);
        IADiccinary.entrenar(0.054);
        IADiccinary.testear();
        IADiccinary.saveMemory(FILENAME+i);
        //IADiccinary.usar("EXIT");
        IADiccinary.cerrar();
        //break;
        }
       /*       
        Generador test= new Generador();
        test.entrenar(0.000001);
        test.testear();
        test.cerrar();
        /     
        Generador test= new Generador();
        test.cargarArchivo("C:\\AppServ\\www\\new\\develop\\res\\exce 0.4\\quien.txt"," - Lina Maria:"," - Jhordy Ar: ");
        test.entrenar(0.001);        
        test.testear();     
        test.usar("EXIT");
        test.cerrar();
        /*%
        Data d= new Data("C:\\AppServ\\www\\new\\develop\\res\\exce 0.4\\QUIEN.txt"," - Lina Maria:"," - Jhordy Ar: ");
        
        for(double[] t:d.getInputs())
            System.out.println(double_toWord(arrayBinarioDecimal(t)));
        System.out.println('\n');
        for(double[] t:d.getOutputs())
            System.out.println(double_toWord(arrayBinarioDecimal(t)));
        */
        
        Enlace exce=new Enlace();
        exce.usar();
                
    }
}
    