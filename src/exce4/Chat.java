/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exce4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Inadaptado
 */
public class Chat extends JFrame implements ActionListener,KeyListener
{
    private final JTextField writer =new JTextField();
    private final JButton send = new JButton("Send");
    public static JTextArea display= new JTextArea();
    private boolean state=true;
    public Chat()
    {
        super("Exce");
        
    }
    public void start ()
    {    
        JPanel bottom =new JPanel();
        bottom.setLayout(new FlowLayout());
        send.addActionListener(this);
        bottom.add(writer);
        writer.setColumns(10);
        writer.addKeyListener(this);
        bottom.add(send);
        
        setLayout(new BorderLayout());
        display.setEnabled(false);
        display.setBackground(Color.black);
        display.setDisabledTextColor(Color.green);
        
        add(display,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);
        setVisible(true);
        setSize(230,300);
        send("Exce: ", "hola");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void send(String sender,String msj)
    {
        String text= display.getText()+sender+msj+"\n"; 
        display.setText(text);
    }
    public void state(boolean s){state=s;}
    public boolean state(){return state;}
    @Override
    public void actionPerformed(ActionEvent e)
    {
        send("User: ",writer.getText());
        writer.setText("");
        state(false);
    }
    @Override
    public void keyReleased(KeyEvent e) 
    {
        if(e.getKeyCode()==10)            
        {
            send("User: ",writer.getText());        
            writer.setText("");
            state(false);
        }      
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

  
    
}
