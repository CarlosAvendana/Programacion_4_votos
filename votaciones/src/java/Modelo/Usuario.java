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
    
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String clave;
    private int activo; 

   
    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String contraseña,int voto) {
        this.id= cedula;
        this.nombre = nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.clave = contraseña;
        this.activo=voto;
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
        getId(), getNombre(), getApellido1(), getApellido2(), getActivo());
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
    
    public boolean idIgualContrasenna(){ 
        return (getClave() == null ?id  == null : getClave().equals(id));
    }         
}
