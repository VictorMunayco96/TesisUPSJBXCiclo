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
public class DNegGastoInterno {
    
    int IdGastoInterno;
    String Fecha;
    String Asunto;
    String Descripcion;
    double MontoTotal;
    int IdSucursal;
    int IdUsuario;
    String Fecha2;
    String Opcion;

    public DNegGastoInterno() {
    }

    public String getFecha2() {
        return Fecha2;
    }

    public void setFecha2(String Fecha2) {
        this.Fecha2 = Fecha2;
    }

    public DNegGastoInterno(int IdGastoInterno, String Fecha, String Asunto, String Descripcion, double MontoTotal, int IdSucursal, int IdUsuario, String Fecha2, String Opcion) {
        this.IdGastoInterno = IdGastoInterno;
        this.Fecha = Fecha;
        this.Asunto = Asunto;
        this.Descripcion = Descripcion;
        this.MontoTotal = MontoTotal;
        this.IdSucursal = IdSucursal;
        this.IdUsuario = IdUsuario;
        this.Fecha2 = Fecha2;
        this.Opcion = Opcion;
    }


    public int getIdGastoInterno() {
        return IdGastoInterno;
    }

    public void setIdGastoInterno(int IdGastoInterno) {
        this.IdGastoInterno = IdGastoInterno;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
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

    public int getIdSucursal() {
        return IdSucursal;
    }

    public void setIdSucursal(int IdSucursal) {
        this.IdSucursal = IdSucursal;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    
     public String DSetNegGastoInterno(DNegGastoInterno Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Neg_GastoInterno(?,?,?,?,?,?,?,?)");

            proc.setInt(1, Campo.getIdGastoInterno());
            proc.setString(2, Campo.getFecha());
            proc.setString(3, Campo.getAsunto());
            proc.setString(4, Campo.getDescripcion());
            proc.setDouble(5, Campo.getMontoTotal());
proc.setInt(6, Campo.getIdSucursal());
proc.setInt(7, Campo.getIdUsuario());
            proc.setString(8, Campo.getOpcion());


            
            proc.execute();
            rpta = "Ingreso correctamente";

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetNegGastoInterno(DNegGastoInterno Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"ID GASTO INTERNO", "FECHA", "ASUNTO", "DESCRIPCION", "MONTO TOTAL", "ID SUCURSAL", "ID USUARIO"};
        String[] registro = new String[7];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Neg_GastoInterno(?,?,?,?)");
         
        proc.setString(1, Campo.getFecha());
proc.setString(2, Campo.getFecha2());
proc.setInt(3, Campo.getIdSucursal());
proc.setString(4, Campo.getOpcion());

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
