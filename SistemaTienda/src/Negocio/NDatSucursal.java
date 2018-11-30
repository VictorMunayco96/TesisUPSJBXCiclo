/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Conexion;
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
public class NDatSucursal {
 
    public DefaultTableModel GET_Sucursal(){
       DefaultTableModel instTableModelSucursal = new DefaultTableModel(new String[]{"IdSucursal","Ubicacion", "Tefono", "Estado"}, 0){
           @Override
           public boolean isCellEditable (int row, int column) { 
            return false ;
           }
       };
        Connection instConnection =  Conexion.Conexion();
       try {
           CallableStatement cst = instConnection.prepareCall("{call PA_GET_Sucursal()}");
           cst.execute();
           ResultSet rs = cst.getResultSet();
           while (rs.next()) {  
                Object[] myObject = new Object[4];
                myObject[0] = rs.getInt(1);
                myObject[1] =rs.getString(2);
                myObject[2] =rs.getString(3);
                myObject[3] =rs.getString(4);

                instTableModelSucursal.addRow(myObject);
           }  
       } catch (SQLException ex) {
           Logger.getLogger(NDatSucursal.class.getName()).log(Level.SEVERE, null, ex);
       }
       return instTableModelSucursal;
   }
}
