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
public class DNegStock {
    int IdStock;
    int Cantidad;
    int IdSucursal;
    int IdProducto;
    String EstadoRegistro;
    String Opcion;
    String Nombre;

    public DNegStock() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public DNegStock(int IdStock, int Cantidad, int IdSucursal, int IdProducto, String EstadoRegistro, String Opcion, String Nombre) {
        this.IdStock = IdStock;
        this.Cantidad = Cantidad;
        this.IdSucursal = IdSucursal;
        this.IdProducto = IdProducto;
        this.EstadoRegistro = EstadoRegistro;
        this.Opcion = Opcion;
        this.Nombre = Nombre;
    }

   

    public int getIdStock() {
        return IdStock;
    }

    public void setIdStock(int IdStock) {
        this.IdStock = IdStock;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getIdSucursal() {
        return IdSucursal;
    }

    public void setIdSucursal(int IdSucursal) {
        this.IdSucursal = IdSucursal;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getEstadoRegistro() {
        return EstadoRegistro;
    }

    public void setEstadoRegistro(String EstadoRegistro) {
        this.EstadoRegistro = EstadoRegistro;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
     public String DSetNegStock(DNegStock Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Neg_Stock(?,?,?,?,?,?)");

            proc.setInt(1, Campo.getIdStock());
            proc.setInt(2, Campo.getCantidad());
            proc.setInt(3, Campo.getIdSucursal());
            proc.setInt(4, Campo.getIdProducto());
            proc.setString(5, Campo.getEstadoRegistro());
            
           
            proc.setString(6, Campo.getOpcion());


            
            proc.execute();
            rpta = "Ingreso correctamente";

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetNegStock(DNegStock Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"IdStock", "Fecha", "Hora", "Cantidad", "IdSucursal", "IdProducto", "EstadoRegistro"};
        String[] registro = new String[7];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Neg_Stock(?,?,?)");
         
        proc.setInt(1, Campo.getIdProducto());
proc.setInt(2, Campo.getIdSucursal());
proc.setString(3, Campo.getOpcion());

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
