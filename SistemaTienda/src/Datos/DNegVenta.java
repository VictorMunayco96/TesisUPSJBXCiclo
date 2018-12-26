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
public class DNegVenta {
      int IdVenta;
    int IdUsuario;
    double IGV;
    double MontoTotal;
    double CuantoDio;
    double Vuelto;
    String TipoRecibo;
    String TipoPago;
    int IdSucursal;
    String Estado;
    String Ruc;
    int DNI;
    String Opcion;

    public DNegVenta() {
    }

    public DNegVenta(int IdVenta, int IdUsuario, double IGV, double MontoTotal, double CuantoDio, double Vuelto, String TipoRecibo, String TipoPago, int IdSucursal, String Estado, String Ruc, int DNI, String Opcion) {
        this.IdVenta = IdVenta;
        this.IdUsuario = IdUsuario;
        this.IGV = IGV;
        this.MontoTotal = MontoTotal;
        this.CuantoDio = CuantoDio;
        this.Vuelto = Vuelto;
        this.TipoRecibo = TipoRecibo;
        this.TipoPago = TipoPago;
        this.IdSucursal = IdSucursal;
        this.Estado = Estado;
        this.Ruc = Ruc;
        this.DNI = DNI;
        this.Opcion = Opcion;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(double MontoTotal) {
        this.MontoTotal = MontoTotal;
    }

    public double getCuantoDio() {
        return CuantoDio;
    }

    public void setCuantoDio(double CuantoDio) {
        this.CuantoDio = CuantoDio;
    }

    public double getVuelto() {
        return Vuelto;
    }

    public void setVuelto(double Vuelto) {
        this.Vuelto = Vuelto;
    }

    public String getTipoRecibo() {
        return TipoRecibo;
    }

    public void setTipoRecibo(String TipoRecibo) {
        this.TipoRecibo = TipoRecibo;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public int getIdSucursal() {
        return IdSucursal;
    }

    public void setIdSucursal(int IdSucursal) {
        this.IdSucursal = IdSucursal;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    
    
    public String DSetNegVenta(DNegVenta Campo) {
        
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        String rpta = "";

        try {
            
            CallableStatement proc = con.prepareCall(" CALL PA_Set_Neg_Venta(?,?,?,?,?,?,?,?,?,?,?,?,?)");

            proc.setInt(1, Campo.getIdVenta());
            proc.setInt(2, Campo.getIdUsuario());
            proc.setDouble(3, Campo.getIGV());
            proc.setDouble(4, Campo.getMontoTotal());
            proc.setDouble(5, Campo.getCuantoDio());
            proc.setDouble(6, Campo.getVuelto());
            proc.setString(7, Campo.getTipoRecibo());
            proc.setString(8, Campo.getTipoPago());
             proc.setInt(9, Campo.getIdSucursal());
           proc.setString(10, Campo.getEstado());
           proc.setString(11, Campo.getRuc());
           proc.setInt(12, Campo.getDNI());
            proc.setString(13, Campo.getOpcion());


            
            proc.execute();
            rpta = "Ingreso correctamente";

            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

         rpta = String.valueOf(e);
        }

        return rpta;

    }
    
    
    public DefaultTableModel DGetNegVenta(DNegVenta Campo) {
        Conexion2 cn = new Conexion2();
        Connection con = cn.Conexion2();
        DefaultTableModel modelo = null;

        String[] titulos = {"IdVenta","IdUsuario", "Fecha"," Hora"," IGV", "MontoTotal", "CuantoDio", "Vuelto", "TipoRecibo", "TipoPago", "IdSucursal", "Estado", "Ruc", "DNI"};
        String[] registro = new String[14];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement proc = con.prepareCall(" CALL PA_Get_Neg_Venta(?,?,?)");
         
        proc.setInt(2, Campo.getIdVenta());
proc.setInt(1, Campo.getIdSucursal());
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
                        registro[9] = rs.getString(10);
                          registro[10] = rs.getString(11);  
                          registro[11] = rs.getString(12);
                            registro[12] = rs.getString(13);  
                            registro[13] = rs.getString(14);
                            
                            
                          
                      
                 
                    
                    
                      
  

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }

    }
    
}
