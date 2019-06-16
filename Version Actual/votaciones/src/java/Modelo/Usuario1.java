package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

public class Usuario1 implements Serializable {

    public Usuario1(String cedula, String apellido1, String apellido2, String nombre, String clave, boolean activo) {
        this.cedula = cedula;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.clave = clave;
        this.activo = activo;
    }

    public Usuario1() {
        this(null, null, null, null, null, false);
    }

    @Override
    public String toString() {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        return g.toJson(this);
    }

    public String getCedula() {
        return cedula;
    }

    @XmlElement(name = "cédula")
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido1() {
        return apellido1;
    }

    @XmlElement(name = "apellido1")
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    @XmlElement(name = "apellido2")
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    @XmlElement(name = "nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    @XmlElement(name = "clave")
    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    @XmlElement(name = "activo")
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    private String cedula;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String clave;
    private boolean activo;
}
