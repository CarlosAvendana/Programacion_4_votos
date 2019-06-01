
//  Administrador.java
//  EIF209 - Programacion 4 -Proeycto #2
//  junio 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña


package Modelo;

import java.io.Serializable;

public class Administrador implements Serializable {

    public Administrador(String id, String nombre, String apellido1, String apellido2, String clave, String observaciones, String user) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.clave = clave;
        this.observaciones = observaciones;
        this.user = user;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String obervaciones) {
        this.observaciones = obervaciones;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    @Override
    public String toString (){
    return String.format("Id:%s , %s %s %s , user: %s, Observaciones: %s ",
            getId(), getNombre(), getApellido1(), getApellido2(),getUser(),getObservaciones());
    }
    
     private String id;
     private String nombre;
     private String apellido1;
     private String apellido2;
     private String clave;
     private String observaciones;
     private String user;
    
}
