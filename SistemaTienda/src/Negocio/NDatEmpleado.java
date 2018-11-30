/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Conexion;
import Datos.DDatEmpleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wendy
 */
public class NDatEmpleado {
     public String SET_Empleado(DDatEmpleado E_DDatEmpleado){
       // OBTENEMOS LA CONEXION A LA DB
       String Result ="";
       Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_Set_Dat_Empleado(?,?,?,?,?,?,?)}");
           cst.setInt(1, E_DDatEmpleado.getIdEmpleado());
           cst.setInt(2, E_DDatEmpleado.getDNI());
           cst.setInt(3, E_DDatEmpleado.getSucursal());
           cst.setString(4, E_DDatEmpleado.getCargo());
           cst.setDouble(5, E_DDatEmpleado.getSueldo());
           cst.setString(6, E_DDatEmpleado.getEstado());
           cst.setString(7, E_DDatEmpleado.getOpcion());
           
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
public DDatEmpleado GET_UNKEmpleado(int DNI){
       DDatEmpleado inst = null ;
        Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_GET_Dat_Empleado(?)}");
           cst.setInt(1, DNI);
           cst.execute();
           ResultSet rs = cst.getResultSet();
           while (rs.next()) {  
                inst = new DDatEmpleado();
                inst.setIdEmpleado(rs.getInt(1));
                inst.setDNI(rs.getInt(2));
                inst.setCargo(rs.getString(3));
                inst.setSueldo(rs.getDouble(4));
                inst.setEstado(rs.getString(5));
                inst.setIdSucursal(rs.getInt(11));
                inst.setNombres(rs.getString(6) + " "+ rs.getString(7));
               
           }  
       } catch (SQLException ex) {
           Logger.getLogger(NUsuPersona.class.getName()).log(Level.SEVERE, null, ex);
       }
       return inst;
   }
public DefaultTableModel GET_Empleado(int DNI){
       DefaultTableModel instTableModelEmpleado = new DefaultTableModel(new String[]{"IdEmpleado", "DNI", "Nombres", "Cargo", "Sueldo", "Estado", "Sucursal","IdSucusar"}, 0){
           @Override
           public boolean isCellEditable (int row, int column) { 
            return false ;
           }
       };
        Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_GET_Dat_Empleado(?)}");
           cst.setInt(1, DNI);
           cst.execute();
           ResultSet rs = cst.getResultSet();
           while (rs.next()) {  
                Object[] myObject = new Object[8];
                myObject[0] = rs.getInt(1);
                myObject[1] =rs.getInt(2);
                myObject[2] =rs.getString(6);
                myObject[3] =rs.getString(3);
                myObject[4] =rs.getString(4);
                myObject[5] =rs.getString(5);
                myObject[6] =rs.getString(12);
                myObject[7] =rs.getString(11);
                instTableModelEmpleado.addRow(myObject);
           }  
       } catch (SQLException ex) {
           Logger.getLogger(NDatEmpleado.class.getName()).log(Level.SEVERE, null, ex);
       }
       return instTableModelEmpleado;
   }
}

