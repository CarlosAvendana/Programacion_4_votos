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

    public Partido(String nombre, String Abreviatura, String Observaciones, Usuario postulante, String idImagenPartido, String idImagenPostulante, int cantVotos) {
        this.nombre = nombre;
        this.Abreviatura = Abreviatura;
        this.Observaciones = Observaciones;
        this.postulante = postulante;
        this.idImagenPartido = idImagenPartido;
        this.idImagenPostulante = idImagenPostulante;
        this.cantVotos = cantVotos;
    }


    
    
        public int getCantVotos() {
        return cantVotos;
    }

    public void setCantVotos(int votos) {
        this.cantVotos = votos;
    }
    
    
    public String getIdImagenPartido() {
        return idImagenPartido;
    }

    public void setIdImagenPartido(String idImagenPartido) {
        this.idImagenPartido = idImagenPartido;
    }

    public String getIdImagenPostulante() {
        return idImagenPostulante;
    }

    public void setIdImagenPostulante(String idImagenPostulante) {
        this.idImagenPostulante = idImagenPostulante;
    }   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getAbreviatura() {
        return Abreviatura;
    }

    public void setAbreviatura(String Abreviatura) {
        this.Abreviatura = Abreviatura;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Usuario getPostulante() {
        return postulante;
    }

    public void setPostulante(Usuario postulante) {
        this.postulante = postulante;
    }

    
    
    private String nombre;
    private String Abreviatura;
    private String Observaciones;
    private Usuario postulante;
    private String idImagenPartido;
    private String idImagenPostulante;
    private int cantVotos;
    
}
