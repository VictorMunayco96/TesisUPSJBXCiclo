/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Wendy
 */
public class DUsuPersona {
    private String Opcion;
    private int DNI;
    private String Nombres;
    private String Apellidos;
    private String Correo;
    private String Direccion;
    private String Celular;

    public DUsuPersona(String Opcion, int DNI, String Nombres, String Apellidos, String Correo, String Direccion, String Celular) {
        this.Opcion = Opcion;
        this.Nombres = Nombres;
        this.DNI = DNI;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Celular = Celular;
    }
    public DUsuPersona() {
       
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }
}
