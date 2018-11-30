/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Wendy
 */
public class Conexion {
    
    
    public static Connection Conexion() 
    {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // WENDY 

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DOcassion?useTimezone=true&serverTimezone=UTC","root","123456"); // WENDY
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +" No se ha podido conectar");
            System.out.println( e);
        }
         return cn;
    }
    
}


