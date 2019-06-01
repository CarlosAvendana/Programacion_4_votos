//  Partido.java
//  EIF209 - Programacion 4 -Proeycto #2
//  junio 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
package Modelo;


public class Partido {

    public Partido(String nombre, String Abreviatura, String Observaciones, Usuario postulante) {
        this.nombre = nombre;
        this.Abreviatura = Abreviatura;
        this.Observaciones = Observaciones;
        this.postulante = postulante;
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
    
}
