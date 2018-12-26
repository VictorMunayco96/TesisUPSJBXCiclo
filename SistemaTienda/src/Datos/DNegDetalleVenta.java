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
public class DNegDetalleVenta {
   
    int IdDetalleVenta;
    int IdVenta;
    int IdProducto;
    double Cantidad;
    double Monto;
    String Opcion;

    public DNegDetalleVenta() {
    }

    public DNegDetalleVenta(int IdDetalleVenta, int IdVenta, int IdProducto, double Cantidad, double Monto, String Opcion) {
        this.IdDetalleVenta = IdDetalleVenta;
        this.IdVenta = IdVenta;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.Monto = Monto;
        this.Opcion = Opcion;
    }

    public int getIdDetalleVenta() {
        return IdDetalleVenta;
    }

    public void setIdDetalleVenta(int IdDetalleVenta) {
        this.IdDetalleVenta = IdDetalleVenta;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    
    public String DSetNegDetalleVenta(DNegDetalleVenta Campo) {
        
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Neg_DetalleVenta(?,?,?,?,?,?)");

            proc.setInt(1, Campo.getIdDetalleVenta());
            proc.setInt(2, Campo.getIdVenta());
            proc.setInt(3, Campo.getIdProducto());
            proc.setDouble(4, Campo.getCantidad());
            proc.setDouble(5, Campo.getMonto());
         
            proc.setString(6, Campo.getOpcion());


            
            proc.execute();
            rpta = "Ingreso correctamente";

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetNegDetalleVenta(DNegDetalleVenta Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"IdDetalleVenta", "IdVenta", "IdProducto", "Nombre", "Descripcion", "Cantidad", "Monto"};
        String[] registro = new String[7];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Neg_DetalleVenta(?,?)");
         
        proc.setInt(1, Campo.getIdVenta());

proc.setString(2, Campo.getOpcion());

            proc.execute();
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                  registro[3] = rs.getString(4);
                  registro[4] = rs.getString(5);
                  registro[5] = rs.getString(6);
                  registro[6] = rs.getString(7);
                   
                            
                          
                      
                 
                    
                    
                      
  

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
    
}
