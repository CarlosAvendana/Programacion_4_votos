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

    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String usuario;
    private String clave;

    public Administrador(String id, String apellido1, String apellido2, String nombre, String usuario, String clave) {
        this.cedula = id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Administrador(String cedula, String nombre, String apellido1, String apllido2, String usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apllido2;
        this.usuario = usuario;
    }

    public Administrador() {
        this(null, null, null, null, null, null);
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return String.format("Id:%s , %s %s %s , user: %s ",
                getCedula(), getNombre(), getApellido1(), getApellido2(), getUsuario());
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<tr>");
        r.append("<th>Cedula: &nbsp </th>");
        r.append(String.format("<td>%s</td>", this.cedula));
        r.append("</tr>");

        r.append("<tr>");
        r.append("<th>Nombre  Completo: &nbsp </th>");
        r.append(String.format("<td>%s %s %s</td>", this.nombre, this.apellido1, this.apellido2));
        r.append("</tr>");

        r.append("<tr>");
        r.append("<th>Usuario: &nbsp </th>");
        r.append(String.format("<td>%s</td>", this.usuario));
        r.append("</tr>");

        return r.toString();

    }

}
