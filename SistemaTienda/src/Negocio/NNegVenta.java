/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DNegVenta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NNegVenta {
    
    
    public String NSetNegStock( int IdVenta,    int IdUsuario,    double IGV,    double MontoTotal,    double CuantoDio,    double Vuelto,    String TipoRecibo,    String TipoPago,
    int IdSucursal,    String Estado,    String Ruc,    int DNI,    String Opcion) {
          
        DNegVenta Obj = new DNegVenta();
        Obj.setIdVenta(IdVenta);
        Obj.setIdUsuario(IdUsuario);
        Obj.setIGV(IGV);
        Obj.setMontoTotal(MontoTotal);
        Obj.setCuantoDio(CuantoDio);
        Obj.setVuelto(Vuelto);
        Obj.setTipoRecibo(TipoRecibo);
        Obj.setTipoPago(TipoPago);
        Obj.setIdSucursal(IdSucursal);
        Obj.setEstado(Estado);
        Obj.setRuc(Ruc);
        Obj.setDNI(DNI);
        Obj.setOpcion(Opcion);
       
    
      

        return Obj.DSetNegVenta(Obj);
    }

    public DefaultTableModel NGetNegStock( int IdVenta, int IdSucursal, String Opcion) {
 DNegVenta Obj = new DNegVenta();
       

 Obj.setIdVenta(IdVenta);
Obj.setIdSucursal(IdSucursal);
Obj.setOpcion(Opcion);

       
      

        return Obj.DGetNegVenta(Obj);
    }
    
    
    
}
