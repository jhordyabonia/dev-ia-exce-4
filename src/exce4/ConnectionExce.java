/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inadaptado
 */
public class ConnectionExce
{
    private Connection conexion;
    private ResultSet rs;
    public ConnectionExce()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    public boolean connect(String s,String u,String p)
    {
        try 
        {
            if(s==null||u==null||p==null)
                conexion = DriverManager.getConnection ("jdbc:mysql://localhost/Exce","root", "");
            else
                conexion = DriverManager.getConnection (s,u, p);
            return true;
        } catch (SQLException ex) {return false;}
    }    
    //@ q: example "select palabra from exce.palabras where id<11"
    public void query(String q)
    {        
        try
        {           
            if(conexion==null){return;}
            
            Statement s = conexion.createStatement();
            rs = s.executeQuery (q);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionExce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet lastResult()
    {   return rs; }
    public void disconnec()
    {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionExce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}
