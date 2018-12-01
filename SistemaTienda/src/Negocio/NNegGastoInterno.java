/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DNegGastoInterno;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NNegGastoInterno {
    public String NSetNegGastoInterno( int IdGastoInterno,String Fecha,String Asunto,String Descripcion, double MontoTotal, int IdSucursal, int IdUsuario,  String Opcion) {
        DNegGastoInterno Obj = new DNegGastoInterno();
       Obj.setIdGastoInterno(IdGastoInterno);
       Obj.setFecha(Fecha);
       Obj.setAsunto(Asunto);
       Obj.setDescripcion(Descripcion);
       Obj.setMontoTotal(MontoTotal);
       Obj.setIdSucursal(IdSucursal);
       Obj.setIdUsuario(IdUsuario);
        Obj.setOpcion(Opcion);

        return Obj.DSetNegGastoInterno(Obj);
    }

    public DefaultTableModel NGetNegGastoInterno( String Fecha, String Fecha2,int IdSucursal, String Opcion) {
       DNegGastoInterno Obj = new DNegGastoInterno();
        Obj.setFecha(Fecha);
Obj.setFecha2(Fecha2);
Obj.setIdSucursal(IdSucursal);

       
       Obj.setOpcion(Opcion);

        return Obj.DGetNegGastoInterno(Obj);
    }
    
}
