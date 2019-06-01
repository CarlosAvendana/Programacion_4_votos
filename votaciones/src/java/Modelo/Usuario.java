//  Usuario.java
//  EIF209 - Programacion 4 -Proeycto #2
//  junio 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña

package Modelo;


public class Usuario {

    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String clave, String obervaciones, boolean esAdmin, String usuario) {
        this.id= cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.clave = clave;
        this.obervaciones = obervaciones;
        this.esAdmin = esAdmin;
        this.usuario = usuario;
    }

    
    // este constructor es para los votantes
    
    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String clave, String obervaciones) {
        this.id = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.clave = clave;
        this.obervaciones = obervaciones;
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

    public String getObervaciones() {
        return obervaciones;
    }

    public void setObervaciones(String obervaciones) {
        this.obervaciones = obervaciones;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public boolean idIgualContrasenna(){ 
    
        return (clave == null ?id  == null : clave.equals(id));
    }        
    
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String clave;
    private String obervaciones;
    private boolean esAdmin;
    private String usuario;
    
    
    
    
}
