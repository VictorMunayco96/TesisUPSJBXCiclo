/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DDatSucursal2;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NDatSucursal2 {
    
    public String NSetDatSucursal( int IdSucursal,     String Ubicacion,     int Telefono,     String Estado,    String Opcion) {
        DDatSucursal2 Obj = new DDatSucursal2();
        Obj.setIdSucursal(IdSucursal);
        Obj.setUbicacion(Ubicacion);
        Obj.setTelefono(Telefono);
        Obj.setEstado(Estado);
   
        Obj.setOpcion(Opcion);

        return Obj.DSetDatSucursal2(Obj);
    }

    public DefaultTableModel NGetDatSucursal( String Opcion) {
       DDatSucursal2 Obj = new DDatSucursal2();
        Obj.setOpcion(Opcion);

        return Obj.DGetDatSucursal2(Obj);
    }
    
    
}
