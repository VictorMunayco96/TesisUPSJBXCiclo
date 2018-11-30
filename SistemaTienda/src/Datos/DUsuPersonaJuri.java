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
public class DUsuPersonaJuri {
    
    String Ruc;
    String Descripcion;
    String Direccion;
    String Opcion;
    public DUsuPersonaJuri() {
    
    }

    public DUsuPersonaJuri(String Ruc, String Descripcion, String Direccion, String Opcion) {
        this.Ruc = Ruc;
        this.Descripcion = Descripcion;
        this.Direccion = Direccion;
        this.Opcion = Opcion;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    
    
    public String DSetUsuPersonaJuri(DUsuPersonaJuri Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Usu_Personajuri(?,?,?,?)");

            proc.setString(1, Campo.getRuc());
            proc.setString(2, Campo.getDescripcion());
             proc.setString(3, Campo.getDireccion());
            proc.setString(4, Campo.getOpcion());


            proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetUsuPersonaJuri(DUsuPersonaJuri Campo) {
        Conexion cn = new Conexion();
        Connection con = cn.Conexion();
        DefaultTableModel modelo = null;

        String[] titulos = {"RUC", "DESCRIPCION", "DIRECCION"};
        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Usu_Personajuri(?,?)");
         
            proc.setString(1, Campo.getRuc());
             proc.setString(2, Campo.getOpcion());

            proc.execute();
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
  

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
}
