/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import Datos.DUsuPersona;
import Helper.Validaciones;
import Negocio.NUsuPersona;
import Validate.Validate;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wendy
 * 
 */
public class PPersona extends javax.swing.JFrame {

    /**
     * Creates new form PUsuPersona
     */
     DUsuPersona instDUsuPersona;
     DefaultTableModel instTableModelPersona;
    public PPersona() {
        initComponents();
        instDUsuPersona = new DUsuPersona();
        instDUsuPersona.setOpcion("I");
        CargarDatos(0);
       
    }

    private void CargarDatos(int DNI){
        TblPersona.setModel(new NUsuPersona().GET_Persona(DNI));
    }
    
    private String Guardar(){
        String Result = "";
        // CREACION DE OBJETO DE LA CLASE PERSONA
        instDUsuPersona.setDNI(Integer.parseInt(TxtDni.getText().toUpperCase()));
        instDUsuPersona.setNombres(TxtNombres.getText().toUpperCase());
        instDUsuPersona.setApellidos(TxtApellidos.getText().toUpperCase());
        instDUsuPersona.setDireccion(TxtDireccion.getText().toUpperCase());
        instDUsuPersona.setCelular(TxtCelular.getText().toUpperCase()); 
        instDUsuPersona.setCorreo(TxtCorreo.getText().toUpperCase());
        Result =  new NUsuPersona().SET_Persona(instDUsuPersona);
        if(Result.equals("Success") == true ) Nuevo();
        CargarDatos(0);
        return !Result.equals("Success") ? Result : "Datos Guardados correctamente";
    }
    
    private void ValidaDatos(){
        
        if(Validaciones.tryParse(TxtDni.getText()) == 0){
            JOptionPane.showMessageDialog(this, "Ingrese nro. DNI valido");
            return;
        }
        else if(TxtDni.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Ingrese nro. DNI");
            return;
        }
        else if(TxtNombres.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Ingrese nombre");
            return;
        }
        else if(TxtApellidos.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Ingrese apellidos");
            return;
        }
        else if(TxtDireccion.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Ingrese dirección");
            return;
        }
        else if(TxtCelular.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Ingrese nro. celular");
            return;
        }
        else if(Validaciones.ValidaEmail(TxtCorreo.getText()) == true){
           // JOptionPane.showMessageDialog(this, "Ingrese cuenta de correo valida");
            return;
        }
    }
    
    public void Nuevo() {
        TxtDni.setText("");
        TxtNombres.setText("");
        TxtApellidos.setText("");
        TxtDireccion.setText("");
        TxtCelular.setText("");
        TxtCorreo.setText("");
        instDUsuPersona.setOpcion("I");
        TxtDni.setEnabled(true);
    }
   
    
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
        TblPersona = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        TxtDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtApellidos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        TxtBusqueda = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        TxtDireccion = new javax.swing.JTextField();
        TxtCelular = new javax.swing.JTextField();
        TxtIdDistrito = new javax.swing.JTextField();
        TxtCorreo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TblPersona.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TblPersona.setModel(new javax.swing.table.DefaultTableModel(
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
        TblPersona.setRowHeight(35);
        TblPersona.setRowMargin(0);
        TblPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblPersonaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TblPersona);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PERSONA");
        jLabel3.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERSONA");
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

        TxtDni.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDniActionPerformed(evt);
            }
        });
        TxtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDniKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("DNI");

        TxtNombres.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtNombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtNombresMousePressed(evt);
            }
        });
        TxtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombresActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setText("NOMBRES");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setText("APELLIDOS");

        TxtApellidos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidosActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setText("DIRECCION");

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel10.setText("CELULAR");

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel12.setText("DNI");

        TxtBusqueda.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtBusquedaMousePressed(evt);
            }
        });
        TxtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaActionPerformed(evt);
            }
        });
        TxtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtBusquedaKeyTyped(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        TxtDireccion.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDireccionActionPerformed(evt);
            }
        });

        TxtCelular.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCelularActionPerformed(evt);
            }
        });
        TxtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCelularKeyTyped(evt);
            }
        });

        TxtIdDistrito.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtIdDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdDistritoActionPerformed(evt);
            }
        });

        TxtCorreo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCorreoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel13.setText("CORREO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TxtIdDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtApellidos))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtDni))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtCelular))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(414, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(507, 507, 507))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIdDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        jTabbedPane1.addTab("", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtIdDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdDistritoActionPerformed

    private void TxtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCelularActionPerformed

    private void TxtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDireccionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

          Nuevo();       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CargarDatos(TxtBusqueda.getText().trim().length() == 0 ? 0: Integer.parseInt(TxtBusqueda.getText()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TxtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaActionPerformed
      
    }//GEN-LAST:event_TxtBusquedaActionPerformed

    private void TxtBusquedaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtBusquedaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBusquedaMousePressed

    private void TxtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidosActionPerformed

    private void TxtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombresActionPerformed

    private void TxtNombresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtNombresMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombresMousePressed

    private void TxtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDniActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // EVENTO DEL BOTON GUARDAR
        ValidaDatos();
        JOptionPane.showMessageDialog(this, Guardar());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TblPersonaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblPersonaMousePressed
        
        try {
            if (evt.getClickCount() == 2) {
                instDUsuPersona.setOpcion("U");
                TxtDni.setEnabled(false);
                
                int fila = TblPersona.getSelectedRow();
                TxtDni.setText(TblPersona.getValueAt(fila, 0).toString());
                TxtNombres.setText(TblPersona.getValueAt(fila, 1).toString());
                TxtApellidos.setText(TblPersona.getValueAt(fila, 2).toString());
                TxtCorreo.setText(TblPersona.getValueAt(fila, 3).toString());
                TxtDireccion.setText(TblPersona.getValueAt(fila, 4).toString());
                TxtCelular.setText(TblPersona.getValueAt(fila, 5).toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_TblPersonaMousePressed

    private void TxtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCorreoActionPerformed

    private void TxtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDniKeyTyped
      
        if(TxtDni.getText().trim().length() > 8){
            evt.consume(); 
        }
        char c=evt.getKeyChar(); 
        if(Character.isLetter(c) ||c == ';' || c == '.' || c == ',') { 
            getToolkit().beep(); 
            evt.consume();      
        } 
    }//GEN-LAST:event_TxtDniKeyTyped

    private void TxtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCelularKeyTyped
      
        if(TxtCelular.getText().trim().length() > 9){
            evt.consume(); 
        }
        char c=evt.getKeyChar(); 
        if(Character.isLetter(c) ||c == ';' || c == '.' || c == ',') {  
            getToolkit().beep(); 
            evt.consume();      
        }   
    }//GEN-LAST:event_TxtCelularKeyTyped

    private void TxtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBusquedaKeyTyped

        if(TxtBusqueda.getText().trim().length() > 8){
            evt.consume(); 
        }
        char c=evt.getKeyChar(); 
        if(Character.isLetter(c) ||c == ';' || c == '.' || c == ',') { 
            getToolkit().beep(); 
            evt.consume();      
        } 
    }//GEN-LAST:event_TxtBusquedaKeyTyped

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
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblPersona;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtBusqueda;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtCorreo;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtDni;
    public static javax.swing.JTextField TxtIdDistrito;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
