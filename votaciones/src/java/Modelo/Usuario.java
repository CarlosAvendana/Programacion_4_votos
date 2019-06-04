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
    private String contraseña;
    private int voto; // dice si true = ya emitío el voto, false = aun no ha botado

   
    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String contraseña,int voto) {
        this.cedula= cedula;
        this.nombre = nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.contraseña = contraseña;
        this.voto=voto;
    }
    
    public Usuario() {
        this(null, null, null, null, null, 0);
    }
   
    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public String toString(){
    return String.format("Id:%s , %s %s %s , voto: %d ",
        getCedula(), getNombre(), getApellido1(), getApellido2(), getVoto());
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public boolean idIgualContrasenna(){ 
        return (getContraseña() == null ?cedula  == null : getContraseña().equals(cedula));
    }         
}
