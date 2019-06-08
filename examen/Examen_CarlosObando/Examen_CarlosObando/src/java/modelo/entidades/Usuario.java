package modelo.entidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String id;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String email;
    private String clave;
    private String telefono;
    private String direccion;
    private static final DateFormat FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Usuario(String id, String apellido1, String apellido2, String nombre, String email, String clave, String telefono, String direccion) {
        this.id = id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Usuario() {
        this(null, null, null, null, null, null, null, null);
    }

    public String getId() {
        return id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public static DateFormat getFMT() {
        return FMT;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format(
                "{%s, %s, %s, %s, %s,%s,%s,%s}",
                id, apellido1, apellido2, nombre, email, clave, telefono, direccion);
    }

    public List<Object> toArray() {
        List<Object> r = new ArrayList<>();
        r.add(this.getId());
        r.add(this.getApellido1());
        r.add(this.getApellido2());
        r.add(this.getNombre());
        r.add(this.getEmail());
        r.add(this.getClave());
        r.add(this.getTelefono());
        r.add(this.getDireccion());
        return r;
    }

    public static Usuario fromArray(ArrayList<String> datos) throws ParseException {

        String id = datos.get(0);
        String apellid1 = datos.get(1);
        String apellid2 = datos.get(2);
        String nombre1 = datos.get(3);
        String email1 = datos.get(4);
        String clave1 = datos.get(5);
        String telefono1 = datos.get(6);
        String direccion1 = datos.get(7);

        return new Usuario(id, apellid1, apellid2, nombre1, email1, clave1, telefono1, direccion1);
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();

        r.append("<tr>");
        r.append(String.format(
                "<td>%s</td><td>%s</td><td>%s</td>",
                this.getId(), this.nombre, this.email, this.telefono, this.direccion));
        r.append("</tr>");

        return r.toString();

    }

}
