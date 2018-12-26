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
public class DNegDetalleCompra {
    int IdDetalleCompra;
    int IdProducto;
    int Cantidad;
    double PrecioUnitario;
    double Monto;
    int IdCompra;
    String Opcion;

    public DNegDetalleCompra() {
    }

    public DNegDetalleCompra(int IdDetalleCompra, int IdProducto, int Cantidad, double PrecioUnitario, double Monto, int IdCompra, String Opcion) {
        this.IdDetalleCompra = IdDetalleCompra;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Monto = Monto;
        this.IdCompra = IdCompra;
        this.Opcion = Opcion;
    }

    public int getIdDetalleCompra() {
        return IdDetalleCompra;
    }

    public void setIdDetalleCompra(int IdDetalleCompra) {
        this.IdDetalleCompra = IdDetalleCompra;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    
    public String DSetNegDetalleCompra(DNegDetalleCompra Campo) {
        
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Neg_DetalleCompra(?,?,?,?,?,?,?)");

            proc.setInt(1, Campo.getIdDetalleCompra());
            proc.setInt(2, Campo.getIdProducto());
            proc.setInt(3, Campo.getCantidad());
            proc.setDouble(4, Campo.getPrecioUnitario());
            proc.setDouble(5, Campo.getMonto());
            proc.setInt(6,Campo.getIdCompra());
         
            proc.setString(7, Campo.getOpcion());


            
            proc.execute();
            rpta = "Ingreso correctamente";

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetNegDetalleCompra(DNegDetalleCompra Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"IdDetalleCompra", "IdProducto", "Nombre", "Descripcion", "Cantidad", "PrecioUnitario", "Monto", "IdCompra"};
        String[] registro = new String[8];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Neg_DetalleCompra(?,?)");
         
      
proc.setInt(1,Campo.getIdCompra());
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
                    registro[7] = rs.getString(8);
     
                   
                            
                          
                      
                 
                    
                    
                      
  

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
    
    
}
