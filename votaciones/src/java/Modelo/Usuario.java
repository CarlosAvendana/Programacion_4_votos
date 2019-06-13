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
    
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String clave;
    private int activo; 

   
    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String contraseña,int activo) {
        this.cedula= cedula;
        this.nombre = nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.clave = contraseña;
        this.activo=activo;
    }
    
    public Usuario() {
        this(null, null, null, null, null, 0);
    }
   
    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString(){
    return String.format("Id:%s , %s %s %s , voto: %d ",
        getCedula(), getNombre(), getApellido1(), getApellido2(), getActivo());
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String id) {
        this.cedula = id;
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
    
    public boolean idIgualContrasenna(){ 
        return (getClave() == null ?cedula  == null : getClave().equals(cedula));
    }      
    
    public String obtenerNombreCompleto(){
    return String.format("%s %s %s",getNombre(),getApellido1(), getApellido2());
    }
}
