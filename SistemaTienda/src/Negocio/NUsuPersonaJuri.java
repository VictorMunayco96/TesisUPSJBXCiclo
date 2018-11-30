/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DUsuPersonaJuri;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VictorHugo
 */
public class NUsuPersonaJuri {
    
    public String NSetUsuPersonaJuri(  String Ruc,    String Descripcion,    String Direccion,    String Opcion) {
        DUsuPersonaJuri Obj = new DUsuPersonaJuri();
        Obj.setRuc(Ruc);
        Obj.setDescripcion(Descripcion);
        Obj.setDireccion(Direccion);
   
        Obj.setOpcion(Opcion);

        return Obj.DSetUsuPersonaJuri(Obj);
    }

    public DefaultTableModel NGetUsuPersonaJuri(String Ruc, String Opcion) {

 DUsuPersonaJuri Obj = new DUsuPersonaJuri();
        Obj.setRuc(Ruc);
        Obj.setOpcion(Opcion);

        return Obj.DGetUsuPersonaJuri(Obj);
    }
    
    
}
