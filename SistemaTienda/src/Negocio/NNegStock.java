/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DNegStock;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NNegStock {
    public String NSetNegStock(  int IdStock,    int Cantidad,    int IdSucursal,    int IdProducto,    String EstadoRegistro,    String Opcion) {
          
        DNegStock Obj = new DNegStock();
        Obj.setIdStock(IdStock);
       
       Obj.setCantidad(Cantidad);
       Obj.setIdSucursal(IdSucursal);
       Obj.setIdProducto(IdProducto);
       Obj.setEstadoRegistro(EstadoRegistro);
      
        Obj.setOpcion(Opcion);

        return Obj.DSetNegStock(Obj);
    }

    public DefaultTableModel NGetNegStock( int IdProducto, int IdSucursal, String Opcion) {
 DNegStock Obj = new DNegStock();
       

 Obj.setIdProducto(IdProducto);
Obj.setIdSucursal(IdSucursal);
Obj.setOpcion(Opcion);

       
      

        return Obj.DGetNegStock(Obj);
    }
}
