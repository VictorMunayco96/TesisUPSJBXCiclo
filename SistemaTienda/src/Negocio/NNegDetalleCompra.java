/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DNegDetalleCompra;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NNegDetalleCompra {
    
    
    public String NSetNegDetalleCompra(   int IdDetalleCompra,    int IdProducto,    int Cantidad,    double PrecioUnitario,    double Monto,    int IdCompra,    String Opcion) {
          
        DNegDetalleCompra Obj = new DNegDetalleCompra();
        Obj.setIdDetalleCompra(IdDetalleCompra);
        Obj.setIdProducto(IdProducto);
        Obj.setCantidad(Cantidad);
        Obj.setPrecioUnitario(PrecioUnitario);
        Obj.setMonto(Monto);
       Obj.setIdCompra(IdCompra);
        Obj.setOpcion(Opcion);
       
    
      

        return Obj.DSetNegDetalleCompra(Obj);
    }

    public DefaultTableModel NGetNegDetalleCompra(int IdCompra,  String Opcion) {
 DNegDetalleCompra Obj = new DNegDetalleCompra();
       

  Obj.setIdCompra(IdCompra);
Obj.setOpcion(Opcion);

       
      

        return Obj.DGetNegDetalleCompra(Obj);
    }
    
    
    
    
    
    
    
}
