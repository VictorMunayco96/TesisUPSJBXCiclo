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
public class DDatEmpleado {
    
    private int IdEmpleado;
    private int DNI;
    private String Cargo;
    private Double Sueldo;
    private String Estado;
    private String Opcion;
    private int Sucursal;
    private String Nombres;

    public int getSucursal() {
        return Sucursal;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setSucursal(int Sucursal) {
        this.Sucursal = Sucursal;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public Double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(Double Sueldo) {
        this.Sueldo = Sueldo;
    }

  

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdSucursal() {
        return IdSucursal;
    }

    public void setIdSucursal(int IdSucursal) {
        this.IdSucursal = IdSucursal;
    }
    private int IdSucursal;
}
