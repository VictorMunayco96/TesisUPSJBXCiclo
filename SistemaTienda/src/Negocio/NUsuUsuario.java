/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Conexion;
import Datos.DUsuUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wendy
 */
public class NUsuUsuario {
    public String SET_Usuario(DUsuUsuario P_DUsuUsuario){
       // OBTENEMOS LA CONEXION A LA DB
       String Result ="";
       Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_Set_Usu_Usuario(?,?,?,?,?,?,?)}");
           cst.setInt(1, P_DUsuUsuario.getIdUsuario());
           cst.setInt(2, P_DUsuUsuario.getIdEmpleado());
           cst.setString(3, P_DUsuUsuario.getUsuario());
           cst.setString(4, P_DUsuUsuario.getContraseña());
            cst.setString(5, P_DUsuUsuario.getTipoUsuario());
           cst.setString(6, P_DUsuUsuario.getEstado());
           cst.setString(7, P_DUsuUsuario.getOpcion());
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
    
    public DefaultTableModel GET_Usuario(String Opcion, String Filtro ){
       DefaultTableModel instTableModelEmpleado = new DefaultTableModel(new String[]{"IdUsuario", "IdEmpleado", "Usuario", "Contraseña", "TipoUsuario", "Estado","DNI","Nombre"}, 0){
           @Override
           public boolean isCellEditable (int row, int column) { 
            return false ;
           }
       };
        Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_GET_Usu_Usuario(?,?)}");
           cst.setString(1, Opcion);
           cst.setString(2, Filtro);
           cst.execute();
           ResultSet rs = cst.getResultSet();
           while (rs.next()) {  
                Object[] myObject = new Object[8];
                myObject[0] = rs.getInt(1);
                myObject[1] =rs.getInt(2);
                myObject[2] =rs.getString(11);
                myObject[3] =rs.getString(12);
                myObject[4] =rs.getString(13);
                myObject[5] =rs.getString(14);
                myObject[6] =rs.getString(3);
                myObject[7] =rs.getString(4);
                instTableModelEmpleado.addRow(myObject);
           }  
       } catch (SQLException ex) {
           Logger.getLogger(NDatEmpleado.class.getName()).log(Level.SEVERE, null, ex);
       }
       return instTableModelEmpleado;
   }
}

