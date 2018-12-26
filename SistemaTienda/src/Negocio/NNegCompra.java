/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DNegCompra;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NNegCompra {
 
    
       public String NSetNegCompra(     int IdCompra,    int IdUsuario,    String Asunto,    String Descripcion,    double MontoTotal,    String Opcion) {
          
        DNegCompra Obj = new DNegCompra();
        Obj.setIdCompra(IdCompra);
        Obj.setIdUsuario(IdUsuario);
        Obj.setAsunto(Asunto);
        Obj.setDescripcion(Descripcion);
        Obj.setMontoTotal(MontoTotal);
        Obj.setOpcion(Opcion);
      
       
    
      

        return Obj.DSetNegCompra(Obj);
    }

    public DefaultTableModel NGetCompra( String Opcion) {
       DNegCompra Obj = new DNegCompra();
       

 
Obj.setOpcion(Opcion);

       
      

        return Obj.DGetNegCompra(Obj);
    }
    
    
    
    
    
}
