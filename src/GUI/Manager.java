/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import exce4.Core;
import exce4.Generador;
import exce4.ManagerCores;
import exce4.WordNormalizer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.encog.neural.networks.BasicNetwork;

/**
 *
 * @author Inadaptado
 */
public class Manager extends javax.swing.JPanel {

    /**
     * Creates new form Manager
     */
    public Manager() {
        initComponents();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        list_objects = new javax.swing.JList();
        field_crear = new javax.swing.JTextField();
        btn_crear = new javax.swing.JButton();
        btn_entrenar = new javax.swing.JButton();
        field_entrenar = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        result_test = new javax.swing.JTextArea();
        btn_testear = new javax.swing.JButton();

        list_objects.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list_objects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_objectsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_objects);

        btn_crear.setText("Crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        btn_entrenar.setText("Entrenar");
        btn_entrenar.setEnabled(false);
        btn_entrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrenarActionPerformed(evt);
            }
        });

        field_entrenar.setEnabled(false);

        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.setEnabled(false);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        result_test.setEditable(false);
        result_test.setColumns(20);
        result_test.setRows(5);
        jScrollPane2.setViewportView(result_test);

        btn_testear.setText("Testear");
        btn_testear.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(field_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(field_entrenar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(btn_entrenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btn_testear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_testear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_guardar)
                            .addComponent(btn_eliminar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_entrenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_entrenar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        if(type==TYPES.GENERADOR)
         manager.add(field_crear.getText(),new Generador());
        else
         manager.add(field_crear.getText(),new WordNormalizer());
            
        field_crear.setText("");
        setListObjets();
        
    }//GEN-LAST:event_btn_crearActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        manager.remove();
        setListObjets();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void list_objectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_objectsMouseClicked
            btn_guardar.setEnabled(true);
            btn_eliminar.setEnabled(true);
            btn_entrenar.setEnabled(true);
            field_entrenar.setEnabled(true);
            btn_testear.setEnabled(true);
            manager.set(list_objects.getSelectedIndex());
    }//GEN-LAST:event_list_objectsMouseClicked

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
     ((Core)manager.get()).saveMemory((String) list_objects.getSelectedValue());
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_entrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrenarActionPerformed
       String[] tmp= field_entrenar.getText().split(",");
       if(type==TYPES.NORMALIZADOR)
       {
           try {               
                if(tmp.length>3){}
               ((WordNormalizer) manager.get()).loadWords(Integer.parseInt(tmp[0]), tmp[1]);
               ((WordNormalizer) manager.get()).entrenar(Double.parseDouble(tmp[2]));
           } catch (SQLException ex) 
           {             
                javax.swing.JOptionPane.showMessageDialog(this, "Syntaxis  sql invalida:\n "
                + "Ej:\n\"select * from exce.palabras where 'id'<5\"", "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
           }
       }
       else
       {
           if(tmp.length>3)
                {
                    ((Core)manager.get()).cargarArchivo(tmp[0], tmp[1],tmp[2]);
                    ((Core)manager.get()).entrenar(Double.parseDouble(tmp[3]));
                }else
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Syntaxis invalida:\n "
                    + "Ej:\nRuta/completa/archvivo,in,out,level_error", "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                }           
       }
    }//GEN-LAST:event_btn_entrenarActionPerformed

    public  javax.swing.JButton get_btn_testear(){return btn_testear;}
    public  javax.swing.JButton get_btn_guardar(){return btn_guardar;}
    public  javax.swing.JButton get_btn_entrenar(){return btn_entrenar;}
    public  javax.swing.JButton get_btn_crear(){return btn_crear;}
    public  javax.swing.JButton get_btn_eliminar(){return btn_eliminar;}
    public javax.swing.JList get_list_objects(){return list_objects;};
    public javax.swing.JTextArea get_result_test(){return result_test;}    
    public javax.swing.JTextField get_field_crear(){return field_crear;}
    public javax.swing.JTextField get_field_entrenar(){return field_entrenar;}
    
    private void setListObjets()
    {
        list_objects.setModel(new javax.swing.AbstractListModel() {
            @Override
            public int getSize() { return manager.size(); }
            @Override
            public Object getElementAt(int i) { return manager.getName(i);  }
        });
    }    
    public void setManager(String s)
    {        
        try {
            this.manager = new ManagerCores(s);
            this.manager.cargar();
            setListObjets();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setType(TYPES t)
    {
        type=t;
    }
    
    //variables declaration  user
    private ManagerCores manager;    
    public static enum TYPES{GENERADOR,NORMALIZADOR};
    private TYPES type=TYPES.GENERADOR;
    // End of variables declaration  user
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_entrenar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_testear;
    private javax.swing.JTextField field_crear;
    private javax.swing.JTextField field_entrenar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList list_objects;
    private javax.swing.JTextArea result_test;
    // End of variables declaration//GEN-END:variables
}
