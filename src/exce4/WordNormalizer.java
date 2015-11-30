/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import static exce4.Language.completar;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;

/**
 *
 * @author Inadaptado
 */
public class WordNormalizer extends Core
{        
    public void loadWords(int size,String sql) throws SQLException
    {
       double[][] WORDS = new double[size][140] ;
        ConnectionExce conn=new ConnectionExce();
        if(conn.connect(null, null, null))
            conn.query(sql);
        
        ResultSet r = conn.lastResult();
        int length=0;
        while(r.next()&&length<size)
        {
            String p=r.getString("sin_acentos");
            WORDS[length]=completar(p.toUpperCase());
            System.out.println(p);
            length++;
        }
        INPUT=WORDS;
        OUTPUT=WORDS;  
        sizeOut = 140;          
        trainingSet = new BasicMLDataSet (INPUT, OUTPUT);
    }
    @Override
    public BasicNetwork make()
    {
        BasicNetwork network_tmp = new BasicNetwork();
        network_tmp.addLayer(new BasicLayer(null,true,140));//INICIO
        network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,840));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,100));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,210));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,420));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),true,210));
        //network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),false,140));
        network_tmp.addLayer(new BasicLayer(new ActivationSigmoid(),false,140));//FIN
        network_tmp.getStructure().finalizeStructure();
        network_tmp.reset() ;
        return network_tmp;
    }
       
    @Override
    protected double[][] setInput()
    {
      return null;
    }

    @Override
    protected double[][] setOutput() 
    {
      return null;
    }
       
}
