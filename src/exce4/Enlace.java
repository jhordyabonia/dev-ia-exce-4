/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inadaptado
 */
public class Enlace 
{
    private Generador izquierdo=new Generador();;
    private Generador derecho=new Generador();
    private SelectorNormalizador normalizador;
    
    public Enlace()
    {
        
        System.out.println("init");
        izquierdo.cargarArchivo("C:\\AppServ\\www\\new\\develop\\res\\exce 0.4\\quien.txt"," - Lina Maria:"," - Jhordy Ar: ");
        izquierdo.entrenar(0.001);        
        //izquierdo.testear();     
        System.out.println("made izq");
        //izquierdo.cerrar();
        
        derecho.cargarArchivo("C:\\AppServ\\www\\new\\develop\\res\\exce 0.4\\quien.txt"," - Jhordy Ar: "," - Lina Maria:");
        derecho.entrenar(0.001);        
        //derecho.testear();   
        System.out.println("made der"); 
        //derecho.cerrar();
        
        try {
             normalizador =new SelectorNormalizador("Normalizadores_de_palabras.txt");
             System.out.println("made normalizador"); 
        } catch (IOException ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void usar()
    {                       
        String pensamiento_actual;
        pensamiento_actual = izquierdo.usar_("HOLA");
        boolean izq=true;
        for(int y=0;y<15;y++)
        //while(!"ADIOS".equals(pensamiento_actual))
        {
            //pensamiento_actual=normalizador.text(pensamiento_actual);
            if(izq)
                pensamiento_actual = izquierdo.usar_(pensamiento_actual);
            else
                pensamiento_actual = derecho.usar_(pensamiento_actual);
            
            if(izq) System.out.println("izq:> "+pensamiento_actual); 
            else System.out.println("der:> "+pensamiento_actual);
            
            izq=!izq;
        }
        //izquierdo.usar("EXIT");
        //derecho.usar("EXIT");
    }
               
    }