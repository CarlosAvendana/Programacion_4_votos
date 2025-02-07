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
import javax.websocket.Decoder.Binary;

public class Partido implements Serializable {

    private String siglas;
    private String nombre;

    private Binary bandera;

    private String observaciones;

    public Partido(String nombre, String siglas, String Observaciones, Binary bandera) {

        this.nombre = nombre;
        this.siglas = siglas;
        this.observaciones = Observaciones;
        this.bandera = bandera;
    }

    public Partido(String siglas, String nombre, String observaciones) {
        this.siglas = siglas;
        this.nombre = nombre;
        this.observaciones = observaciones;
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
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Binary getBandera() {
        return bandera;
    }

    public void setBandera(Binary bandera) {
        this.bandera = bandera;
    }

}
