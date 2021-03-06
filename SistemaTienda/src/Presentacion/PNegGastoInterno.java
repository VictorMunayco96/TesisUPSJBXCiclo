/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.NNegGastoInterno;
import Validate.Validate;
import ZMensajes.Save;
import ZMensajes.Error;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PNegGastoInterno extends javax.swing.JFrame {

    /**
     * Creates new form PNegGastoInterno
     */
    public PNegGastoInterno() {
        initComponents();
        GetTabla("D");
        TxtIdGastoInterno.setVisible(false);
    }

    
    
     
    //MENSAJE

    public void MensajeConfirm(String Mensaje) {
        Save Obj = new Save();
        Obj.setVisible(true);
        Obj.setLocationRelativeTo(null);
        ZMensajes.Save.LblSaveMensaje.setText(Mensaje);
    }

 

    public void MensajeError(String Mensaje) {

         Error Obj = new Error();
        Obj.setVisible(true);
        Obj.setLocationRelativeTo(null);
        ZMensajes.Error.LblErrorMensaje.setText(Mensaje);
    }  
      // FIN
    
    
     //VARIABLES GLOBALES
   
        NNegGastoInterno GastosInternos = new NNegGastoInterno();
    String Accion = "I";
    
    
      //FIN
    
    
        //METODOS
    public void Nuevo() {
      TxtIdGastoInterno.setText("");
      TxtAsunto.setText("");
   TxtDescripcion.setText("");
      TxtMontoTotal.setText("");
      
      Accion = "I";
      
    }


    public void OcultarColumna(JTable Tabla, int Columna) {
        Tabla.getColumn(Tabla.getColumnName(Columna)).setWidth(0);
        Tabla.getColumn(Tabla.getColumnName(Columna)).setMinWidth(0);
        Tabla.getColumn(Tabla.getColumnName(Columna)).setMaxWidth(0);
    }

    public void GetTabla(String Accion) {

        try {

            TblGastosInternos.setModel(GastosInternos.NGetNegGastoInterno("","",Integer.parseInt(PInicio.LblIdSucursalInicio.getText()),Accion)); 
           
            OcultarColumna(TblGastosInternos, 0);
             
            
        } catch (Exception e) {
            
            MensajeError(String.valueOf(e));
            System.out.println(e);
        }
    }
    
    //VALIDAR DATOS
    private boolean ValidaDatos(){
        
        if(TxtAsunto.getText().trim().length() == 0){
            MensajeError("INGRESE UBICACION");
            return false;
        }
        else if(TxtDescripcion.getText().trim().length() == 0){
            MensajeError("INGRESE TELEFONO");
            return false;
        }
          else if(TxtMontoTotal.getText().trim().length() == 0){
              
            MensajeError("INGRESE TELEFONO");
            
            return false;
        }
       
      return true;
    }
    
    //FIN
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblGastosInternos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        TxtAsunto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        TxtIdGastoInterno = new javax.swing.JTextField();
        TxtMontoTotal = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TblGastosInternos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TblGastosInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblGastosInternos.setRowHeight(35);
        TblGastosInternos.setRowMargin(0);
        TblGastosInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblGastosInternosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TblGastosInternos);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GASTOS INTERNOS");
        jLabel3.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GASTOS INTERNOS");
        jLabel1.setOpaque(true);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Guardar-32.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TxtAsunto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAsuntoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("ASUNTO");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setText("DESCRIPCION");

        TxtDescripcion.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDescripcionActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Nuevo.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel16.setText("MONTO TOTAL");

        TxtIdGastoInterno.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtIdGastoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdGastoInternoActionPerformed(evt);
            }
        });

        TxtMontoTotal.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtMontoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMontoTotalActionPerformed(evt);
            }
        });
        TxtMontoTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtMontoTotalKeyTyped(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Eliminar -32.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TxtIdGastoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtIdGastoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 27, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TblGastosInternosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblGastosInternosMousePressed
try {
              if (evt.getClickCount() == 2) {
            Accion = "U";
            int fila = TblGastosInternos.getSelectedRow();
            
            TxtIdGastoInterno.setText(TblGastosInternos.getValueAt(fila, 0).toString());
            TxtAsunto.setText(TblGastosInternos.getValueAt(fila, 2).toString());
            TxtDescripcion.setText(TblGastosInternos.getValueAt(fila, 3).toString());
            TxtMontoTotal.setText(TblGastosInternos.getValueAt(fila, 4).toString());
           
        }
        } catch (Exception e) {
            MensajeError("NO SE PUEDE EDITAR");
            System.out.println(e);
        }       
    }//GEN-LAST:event_TblGastosInternosMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if (ValidaDatos()){
       if (Accion.equals("I")) {
      

               
                    try {
                      GastosInternos.NSetNegGastoInterno(0,"",
                              Validate.Text(TxtAsunto.getText()),
                              Validate.Text(TxtDescripcion.getText()),
                              Double.parseDouble(TxtMontoTotal.getText()),
                              Integer.parseInt(PInicio.LblIdSucursalInicio.getText()),
                              Integer.parseInt(PInicio.LblIdUsuarioInicio.getText()),
                              Accion);
                                
                              
                        GetTabla("D");

                        MensajeConfirm("REGISTRO GUARDADO");
                        Nuevo();
                    } catch (Exception e) {
                        MensajeError(String.valueOf(e));
                        
                    }

             
            
        } else  {

            
                try {
                    //MODIFICAR
                    GastosInternos.NSetNegGastoInterno(Validate.Number(TxtIdGastoInterno.getText()),"",
                              Validate.Text(TxtAsunto.getText()),
                              Validate.Text(TxtDescripcion.getText()),
                              Double.parseDouble(TxtMontoTotal.getText()),
                              Integer.parseInt(PInicio.LblIdSucursalInicio.getText()),
                              Integer.parseInt(PInicio.LblIdUsuarioInicio.getText()),
                              Accion);
                                
                              
                        GetTabla("D");

                        MensajeConfirm("REGISTRO MODIFICADO");
                        Nuevo();
                } catch (Exception e) {
                    MensajeError(String.valueOf(e));
                
            }
       }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TxtAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAsuntoActionPerformed

    }//GEN-LAST:event_TxtAsuntoActionPerformed

    private void TxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDescripcionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
Nuevo();                // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void TxtIdGastoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdGastoInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdGastoInternoActionPerformed

    private void TxtMontoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMontoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMontoTotalActionPerformed

    private void TxtMontoTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMontoTotalKeyTyped
       if(TxtMontoTotal.getText().trim().length() > 8){
            evt.consume(); 
        }
        char c=evt.getKeyChar(); 
        if(Character.isLetter(c) ||c == ';' || c == ',') { 
            getToolkit().beep(); 
            evt.consume();      
        }     
    }//GEN-LAST:event_TxtMontoTotalKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
           try {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿ESTAS SEGURO DE ELIMINAR REGISTRO?", "MENSAJE", 2);
            if (confirmacion == 0) {

                int fila = TblGastosInternos.getSelectedRow();

                GastosInternos.NSetNegGastoInterno(Validate.Number(TxtIdGastoInterno.getText()),"",
                             "",
                              "",
                              0,
                              0,
                              0,
                              "D");
          GetTabla("D");
                MensajeConfirm("REGISTRO ELIMINADO");
                Nuevo();
            }
        } catch (Exception e) {
            MensajeError(String.valueOf(e));
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PNegGastoInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PNegGastoInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PNegGastoInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PNegGastoInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PNegGastoInterno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblGastosInternos;
    private javax.swing.JTextField TxtAsunto;
    private javax.swing.JTextField TxtDescripcion;
    public static javax.swing.JTextField TxtIdGastoInterno;
    private javax.swing.JTextField TxtMontoTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
