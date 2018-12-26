/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class DNegCompra {
    int IdCompra;
    int IdUsuario;
    String Asunto;
    String Descripcion;
    double MontoTotal;
    String Opcion;

    public DNegCompra() {
    }

    public DNegCompra(int IdCompra, int IdUsuario, String Asunto, String Descripcion, double MontoTotal, String Opcion) {
        this.IdCompra = IdCompra;
        this.IdUsuario = IdUsuario;
        this.Asunto = Asunto;
        this.Descripcion = Descripcion;
        this.MontoTotal = MontoTotal;
        this.Opcion = Opcion;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(double MontoTotal) {
        this.MontoTotal = MontoTotal;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
     public String DSetNegCompra(DNegCompra Campo) {
        
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Neg_Compra(?,?,?,?,?,?)");

            proc.setInt(1, Campo.getIdCompra());
            proc.setInt(2, Campo.getIdUsuario());
            proc.setString(3, Campo.getAsunto());
            proc.setString(4, Campo.getDescripcion());
            proc.setDouble(5, Campo.getMontoTotal());
         
            proc.setString(6, Campo.getOpcion());


            
            proc.execute();
            rpta = "Ingreso correctamente";

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetNegCompra(DNegCompra Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"IdCompra", "IdUsuario", "Fecha", "Asunto", "Descripcion", "MontoTotal"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Neg_Compra(?)");
         
      

proc.setString(1, Campo.getOpcion());

            proc.execute();
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                  registro[3] = rs.getString(4);
                  registro[4] = rs.getString(5);
                  registro[5] = rs.getString(6);
     
                   
                            
                          
                      
                 
                    
                    
                      
  

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
}
