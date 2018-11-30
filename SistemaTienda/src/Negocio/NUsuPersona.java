/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Conexion;
import Datos.DUsuPersona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wendy
 */
public class NUsuPersona {
   public String SET_Persona(DUsuPersona P_DUsuPersona){
       // OBTENEMOS LA CONEXION A LA DB
       String Result ="";
       Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_Set_Usu_Persona(?,?,?,?,?,?,?)}");
           cst.setInt(1, P_DUsuPersona.getDNI());
           cst.setString(2, P_DUsuPersona.getNombres());
           cst.setString(3, P_DUsuPersona.getApellidos());
           cst.setString(4, P_DUsuPersona.getCorreo());
           cst.setString(5, P_DUsuPersona.getDireccion());
           cst.setString(6, P_DUsuPersona.getCelular());
           cst.setString(7, P_DUsuPersona.getOpcion());
           cst.execute();
           ResultSet rs = cst.getResultSet();
           while (rs.next()) {  
                Result =rs.getString(1);
            }  
       } catch (SQLException ex) {
           Logger.getLogger(NUsuPersona.class.getName()).log(Level.SEVERE, null, ex);
       }
       return Result;
   }
   
   
   public DUsuPersona GET_UNKPersona(int DNI){
       DUsuPersona inst = null ;
        Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_GET_Usu_Persona(?)}");
           cst.setInt(1, DNI);
           cst.execute();
           ResultSet rs = cst.getResultSet();
           while (rs.next()) {  
                inst = new DUsuPersona();
                inst.setDNI(rs.getInt(1));
                inst.setNombres(rs.getString(2));
                inst.setApellidos(rs.getString(3));
                inst.setCorreo(rs.getString(4));
                inst.setDireccion(rs.getString(5));
                inst.setCelular(rs.getString(6));
           }  
       } catch (SQLException ex) {
           Logger.getLogger(NUsuPersona.class.getName()).log(Level.SEVERE, null, ex);
       }
       return inst;
   }
   
   public DefaultTableModel GET_Persona(int DNI){
       DefaultTableModel instTableModelPersona = new DefaultTableModel(new String[]{"DNI", "Nombres", "Apellidos", "Correo", "Direccion", "Celular"}, 0){
           @Override
           public boolean isCellEditable (int row, int column) { 
            return false ;
           }
       };
        Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_GET_Usu_Persona(?)}");
           cst.setInt(1, DNI);
           cst.execute();
           ResultSet rs = cst.getResultSet();
           while (rs.next()) {  
                Object[] myObject = new Object[6];
                myObject[0] = rs.getInt(1);
                myObject[1] =rs.getString(2);
                myObject[2] =rs.getString(3);
                myObject[3] =rs.getString(4);
                myObject[4] =rs.getString(5);
                myObject[5] =rs.getString(6);
                instTableModelPersona.addRow(myObject);
           }  
       } catch (SQLException ex) {
           Logger.getLogger(NUsuPersona.class.getName()).log(Level.SEVERE, null, ex);
       }
       return instTableModelPersona;
   }
}
