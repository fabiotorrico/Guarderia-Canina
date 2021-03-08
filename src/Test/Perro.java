/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
/**
 *
 * @author Fabio
 */
public class Perro {
            //*Atributos
    
    private int codigo, cantDias;
    private String nombre, raza, nombreDuenio, telefonoDuenio;
    private char genero;
    private Fecha FechaIngreso;
        //*Constructores

    public Perro(int codigo) {
        this.codigo = codigo;
    }
        //* Modificadores
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public void setTelefonoDuenio(String telefonoDuenio) {
        this.telefonoDuenio = telefonoDuenio;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setFechaIngreso(Fecha FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

        //*Observadores
    public int getCodigo() {
        return codigo;
    }

    public int getCantDias() {
        return cantDias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public String getTelefonoDuenio() {
        return telefonoDuenio;
    }

    public char getGenero() {
        return genero;
    }

    public Fecha getFechaIngreso() {
        return FechaIngreso;
    }
    
    public String toString() {
        
        return "Perro :.\n"+
                    " Codigo = " + codigo + ".\n"+
                    " Cantidad de Dias = " + cantDias + ".\n"+
                    " Nombre del Perro = " + nombre + ".\n"+
                    " Raza = " + raza + ".\n"+
                    " Nombre del Duenio = " + nombreDuenio + ".\n"+
                    " Telefono del Duenio = " + telefonoDuenio + ".\n"+
                    " Genero = " + genero + ".\n"+
                    " Fecha De Ingreso = " + FechaIngreso;
        }

    
    
    
    
    
    
}
    

