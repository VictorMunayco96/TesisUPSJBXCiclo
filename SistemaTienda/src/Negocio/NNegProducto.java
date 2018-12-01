/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DNegProducto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NNegProducto {
      public String NSetNegProducto( int IdProducto,    String CodBarra,    String Nombre,    String Descripcion,    String Categoria,    double PrecioVenta,    double PrecioDescuento,
    int Popularidad,    String Estado,    String Opcion) {
          
        DNegProducto Obj = new DNegProducto();
        
       Obj.setIdProducto(IdProducto);
       Obj.setCodBarra(CodBarra);
       Obj.setNombre(Nombre);
       Obj.setDescripcion(Descripcion);
       Obj.setCategoria(Categoria);
       Obj.setPrecioVenta(PrecioVenta);
       Obj.setPrecioDescuento(PrecioDescuento);
       Obj.setPopularidad(Popularidad);
       Obj.setEstado(Estado);
        Obj.setOpcion(Opcion);

        return Obj.DSetNegProducto(Obj);
    }

    public DefaultTableModel NGetNegProducto( String Nombre, String Categoria, String Opcion) {
     DNegProducto Obj = new DNegProducto();
        Obj.setNombre(Nombre);
Obj.setCategoria(Categoria);
Obj.setOpcion(Opcion);

       
      

        return Obj.DGetNegProducto(Obj);
    }
}
