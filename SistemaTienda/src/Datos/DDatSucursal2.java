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
public class DDatSucursal2 {
    
     int IdSucursal;
     String Ubicacion;
     int Telefono;
     String Estado;
    String Opcion;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public DDatSucursal2(int IdSucursal, String Ubicacion, int Telefono, String Estado, String Opcion) {
        this.IdSucursal = IdSucursal;
        this.Ubicacion = Ubicacion;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.Opcion = Opcion;
    }

    public DDatSucursal2() {
    }

 

    public int getIdSucursal() {
        return IdSucursal;
    }

    public void setIdSucursal(int IdSucursal) {
        this.IdSucursal = IdSucursal;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    public String DSetDatSucursal2(DDatSucursal2 Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Dat_Sucursal(?,?,?,?,?)");

            proc.setInt(1, Campo.getIdSucursal());
            proc.setString(2, Campo.getUbicacion());
             proc.setInt(3, Campo.getTelefono());
            proc.setString(4, Campo.getEstado());
            proc.setString(5, Campo.getOpcion());


            proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetDatSucursal2(DDatSucursal2 Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"ID SUCURSAL", "UBICACION", "TELEFONO","ESTADO"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Dat_Sucursal(?)");
         

             proc.setString(1, Campo.getOpcion());

            proc.execute();
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                  registro[3] = rs.getString(4);
  

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
    
}
