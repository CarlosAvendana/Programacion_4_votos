//  Usuario.java
//  EIF209 - Programacion 4 -Proeycto #2
//  junio 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña

package Modelo;

import java.io.Serializable;


public class Usuario  implements Serializable {

   
    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String clave, String observaciones) {
        this.id= cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.clave = clave;
        this.observaciones = observaciones;
        
    }

     public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }


    @Override
    public String toString(){
    return  String.format("Id:%s , %s %s %s , voto: %b, Observaciones: %s ",
            getId(), getNombre(), getApellido1(), getApellido2(), isVoto(), getObservaciones());
     }

    public String getId() {
        return id;
    }

    public void setId(String cedula) {
        this.id = cedula;
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

    public void setObervaciones(String obervaciones) {
        this.observaciones = obervaciones;
    }

        public boolean idIgualContrasenna(){ 
    
        return (clave == null ?id  == null : clave.equals(id));
    }        
    
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String clave;
    private String observaciones;
     private boolean voto; // dice si true = ya emitío el voto, false = aun no ha botado
    
    
}
