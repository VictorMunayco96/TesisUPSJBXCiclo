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
public class DNegProducto {
    
    
    int IdProducto;
    String CodBarra;
    String Nombre;
    String Descripcion;
    String Categoria;
    double PrecioVenta;
    double PrecioDescuento;
    int Popularidad;
    String Estado;
    String Opcion;

    public DNegProducto() {
    }

    public DNegProducto(int IdProducto, String CodBarra, String Nombre, String Descripcion, String Categoria, double PrecioVenta, double PrecioDescuento, int Popularidad, String Estado, String Opcion) {
        this.IdProducto = IdProducto;
        this.CodBarra = CodBarra;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.PrecioVenta = PrecioVenta;
        this.PrecioDescuento = PrecioDescuento;
        this.Popularidad = Popularidad;
        this.Estado = Estado;
        this.Opcion = Opcion;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getCodBarra() {
        return CodBarra;
    }

    public void setCodBarra(String CodBarra) {
        this.CodBarra = CodBarra;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public double getPrecioDescuento() {
        return PrecioDescuento;
    }

    public void setPrecioDescuento(double PrecioDescuento) {
        this.PrecioDescuento = PrecioDescuento;
    }

    public int getPopularidad() {
        return Popularidad;
    }

    public void setPopularidad(int Popularidad) {
        this.Popularidad = Popularidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
      public String DSetNegProducto(DNegProducto Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Neg_Producto(?,?,?,?,?,?,?,?,?,?)");

            proc.setInt(1, Campo.getIdProducto());
            proc.setString(2, Campo.getCodBarra());
            proc.setString(3, Campo.getNombre());
            proc.setString(4, Campo.getDescripcion());
            proc.setString(5, Campo.getCategoria());
            
            proc.setDouble(6, Campo.getPrecioVenta());
            proc.setDouble(7, Campo.getPrecioDescuento());
            proc.setInt(8, Campo.getPopularidad());
            proc.setString(9, Campo.getEstado());
            proc.setString(10, Campo.getOpcion());


            
            proc.execute();
            rpta = "Ingreso correctamente";

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetNegProducto(DNegProducto Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"ID PRODUCTO", "COD BARRA","NOMBRE", "DESCRIPCION", "CATEGORIA","PRECIO VENTA", "PRECIO DESCUENTO", "POPULARIDAD", "ESTADO"};
        String[] registro = new String[9];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Neg_Producto(?,?,?)");
         
        proc.setString(1, Campo.getNombre());
proc.setString(2, Campo.getCategoria());
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
                    registro[7] = rs.getString(8);
                      registro[8] = rs.getString(9);
  

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
}
