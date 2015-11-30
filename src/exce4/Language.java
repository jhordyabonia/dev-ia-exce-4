/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import java.util.Random;

/**
 *
 * @author Inadaptado
 */
public interface Language 
{
    public static int BINARY_LENGTH=7;
    
    String ALPHA[]={" "," "," ","A","A","A","B","B","B","C","C","C","D","D","D","E","E",
        "E","F","F","F","G","G","G","H","H","H","J","J","J","I","I","I","K","K",
        "K","L","L","L","M","M","M","N","N","N","O","O","O","P","P","P","Q","Q",
        "Q","R","R","R","S","S","S","T","T","T","U","U","U","V","V","V","W","W",
        "X","X","X","Y","Y","Y","Z","Z","Z"};
    
   public static double[] normaliceDecimal(double t[])
   {
       for(int u=0;u<t.length;u++)
        t[u]=t[u]/ALPHA.length;
       return t;
   }
   public static double[] unNormaliceDecimal(double t[])
   {
       for(int u=0;u<t.length;u++)
        t[u]=t[u]*ALPHA.length;
       return t;
   }
   public static double[] completar(String in)
   {
       int a=in.length();
       if(a<50)
         for(int i=0;i<50-a;i++)
           in+=" ";
       else
         in=in.substring(0, 50);
       return arrayDecimalBinario(word_toDouble(in)); //Salida en bnario 50*BINARY_LENGTH
       //return normaliceDecimal(word_toDouble(in)); //Salida normalizada 50
   }
   public static double[] reverse(double t[])
   {
       double out[]=new double[t.length];
       for(int i=0;i<t.length;i++)
           out[i]=t[t.length-i-1];      
       return out;
   }
   public static double[] arrayDecimalBinario(double t[])
   {
       double out[]=null;
       
       for(double v:t)
       {
        out=joinArray(out,decimalBinario(v));   
       }       
       return out;       
   }public static double[] arrayBinarioDecimal(double t[])
   {
       double out[]=new double[t!=null?(int)(t.length/BINARY_LENGTH):0];
       double tmp[][]=new double[t!=null?(int)(t.length/BINARY_LENGTH):0][BINARY_LENGTH];
       
       for(int i=0,x=0;i<(int)t.length/BINARY_LENGTH;i++)
        for(int a=0;a<BINARY_LENGTH;a++,x++)
            tmp[i][a]=t[x];
       
       for(int p=0;p<tmp.length;p++)
       {
           out[p]=binarioDecimal(tmp[p]);
       }               
       return out;       
   }
    public static double[] decimalBinario(double t)
    {
        double out[]=new double[BINARY_LENGTH];
        int i;
        for(i=0;t>0&&i<BINARY_LENGTH;i++)
        {
            out[i]=t%2;
            if(out[i]==0) t=t/2;
            else t=(t-1)/2;
        }
        //out[i]=t;
        for(i=i;i<BINARY_LENGTH;i++){out[i]=0;}
        
        return out;
    }public static double binarioDecimal(double t[])
    {
        double out=0;
        for(int i=0;i<t.length;i++)
        {
            out+=expo(2,i)*t[i];
        }
        
        return out;
    }
    public static double expo(double t, double v)
    {
        double out=t;
        if(v==0)return 1;
        for(int i=1;i<v;i++)
            out*=t;
        return out;
    }
    public static double [] joinArray(double t[],double v[])
    {
        double [] out =new double[(t!=null? t.length:0)+(v!=null? v.length:0)];
        int i=0;
        if(t!=null)
            for(i=0;i<t.length;i++)
                out[i]=t[i];
        if(v!=null)
            for(int a=0;a<v.length;a++)
                out[a+i]=v[a];
        return out;
    }
    public static boolean is_vocal(String c)
    {
        return "A".equals(c)||"E".equals(c)||"I".equals(c)||"O".equals(c)||"U".equals(c);
    }
    public  static int char_p(String c)
    {
        for(int i=0;i<ALPHA.length;i++)
        {
            if(c == null ? ALPHA[i] == null : c.equals(ALPHA[i]))
            return i+1;     
        }
        return -1;
    }
    public static double[] word_toDouble(String word)
    {
        double[] out=new double[word.length()];
        for(int i=0;i<word.length();i++)
          out[i]=char_p(word.charAt(i)+"");
        return out;
    }
    public static String double_toWord(double[] i)
    {
        String out="";
        
        for(double item:i)
        {   
            if(item==-1||item>=ALPHA.length)
                out+='*';
            else
             out+=ALPHA[(int) item];  
        }
        
        return out;
    }
    public static String[] word()
    {
      
         String alpha_cons[]={"B","C","C","C","D","D","D","F","G","H","J",
        "K","L","L","L","M","M","M","N","N","N","N","P","P","QUI","QUE","R","R",
        "R","R","R","S","S","S","T","T","T","T","V","W","X","Y","Z","BL","BR","CL","CR",
        "FL","FR","GL","GR","PL","PR","TL","TR","DR","Q"," "};
    
        String[] alpha_vocal={null,"A","A","A","A","A","A","A","E","E","E",
        "E","E","E","I","I","I","I","I","O","O","O","O","O","O","U","U","U"};    
        String phrase="";
        String out[]; Random rnd = new Random();
        int length_word=(int)(rnd.nextDouble() * 13);
        int start=rnd.nextInt();
        //System.out.println(ALPHA_CONS[12]);
        int preview=-1;
        out=new String[length_word];
        for(int i=0;i<length_word;i+=2)
        {   
            int num_cons=(int)(rnd.nextDouble() * alpha_cons.length);
            int num_vocal=(int)(rnd.nextDouble() * alpha_vocal.length);
            if(start>-1073741824)
            {
                phrase+=alpha_cons[num_cons];
                if(num_cons==12||num_cons==13||num_cons==preview){out[i]=" "; continue;}
                phrase+=alpha_vocal[num_vocal];
                out[i]=phrase;
                preview=num_cons;
            }else
            {
                phrase+=alpha_vocal[num_vocal];                
                phrase+=alpha_cons[num_cons];
                
                out[i]=phrase;
            }
        }
        return out;
    }    
}
