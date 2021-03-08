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
public class Fecha {
     public int dia,mes,anio;
    
//Contructores
public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
}

//Modificadores
       
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

// Observadores

    public int getDia() {
        return dia;
        
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public String toString() {
        return "Fecha = " + dia + "/" + mes + "/" + anio;
    }
        
// Metodos propios del tipo
    
    
    public boolean equals(Fecha f) {
        boolean igual=false;
        
        if ((this.dia==f.getDia()&&(this.mes==f.getMes())&&(this.anio==f.getAnio()))) {
            igual=true;
        }
        return igual;
    }
}
