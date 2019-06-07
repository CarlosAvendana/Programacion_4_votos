//  Partido.java
//  EIF209 - Programacion 4 -Proeycto #2
//  junio 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
package Modelo;

import java.io.Serializable;


public class Partido implements Serializable  {

    public Partido(String nombre, String siglas, String Observaciones,String bandera) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.Observaciones = Observaciones;
        this.bandera=bandera;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
    private String siglas;
    private String nombre;
    private String Observaciones;
    private String bandera;
    
}
