/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DNegDetalleVenta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NNegDetalleVenta {
    
    
    
    public String NSetNegDetalleVenta(  int IdDetalleVenta,    int IdVenta,    int IdProducto,    double Cantidad,    double Monto,    String Opcion) {
          
        DNegDetalleVenta Obj = new DNegDetalleVenta();
        Obj.setIdDetalleVenta(IdDetalleVenta);
        Obj.setIdVenta(IdVenta);
        Obj.setIdProducto(IdProducto);
        Obj.setCantidad(Cantidad);
        Obj.setMonto(Monto);
       
        Obj.setOpcion(Opcion);
       
    
      

        return Obj.DSetNegDetalleVenta(Obj);
    }

    public DefaultTableModel NGetNegDetalleVenta(int IdVenta,  String Opcion) {
 DNegDetalleVenta Obj = new DNegDetalleVenta();
       

  Obj.setIdVenta(IdVenta);
Obj.setOpcion(Opcion);

       
      

        return Obj.DGetNegDetalleVenta(Obj);
    }
    
    
    
    
    
}
