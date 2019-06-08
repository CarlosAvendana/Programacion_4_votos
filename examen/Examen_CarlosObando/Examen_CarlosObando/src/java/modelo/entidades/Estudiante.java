package modelo.entidades;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private String id;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String email;
    private String clave;
    private String telefono;
    private String direccion;

    public Estudiante(String id, String apellido1, String apellido2, String nombre, String email, String clave, String telefono, String direccion) {
        this.id = id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Estudiante() {
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

    public static Estudiante fromArray(ArrayList<String> datos) throws ParseException {
        String i = datos.get(0);
        String ap1 = datos.get(1);
        String ap2 = datos.get(2);
        String nom = datos.get(3);
        String ema = datos.get(4);
        String clave = datos.get(5);
        String telefono = datos.get(6);
        String direccion = datos.get(7);

        return new Estudiante(i, ap1, ap2, nom, ema, clave, telefono, direccion);
    }

    public List<Object> toArray() {
        List<Object> r = new ArrayList<>();
        r.add(getId());
        r.add(getApellido1());
        r.add(getApellido2());
        r.add(getNombre());
        r.add(getEmail());
        r.add(getClave());
        r.add(getTelefono());
        r.add(getDireccion());
        return r;
    }

    @Override
    public String toString() {
        return String.format(
                "{%s, %s, %s, %s, %s,%s,%s,%s}",
                id, apellido1, apellido2, nombre, email, clave, telefono, direccion);
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<tr>");
        r.append("<th>ID: &nbsp </th>");
        r.append(String.format("<td>%s</td>", this.id));
        r.append("</tr>");

        r.append("<tr>");
        r.append("<th>Nombre  Completo: &nbsp </th>");
        r.append(String.format("<td>%s</td><td>%s</td><td>%s</td>", this.nombre, this.apellido1, this.apellido2));
        r.append("</tr>");

        r.append("<tr>");
        r.append("<th>Email: &nbsp </th>");
        r.append(String.format("<td>%s</td>", this.email));
        r.append("</tr>");

        r.append("<tr>");
        r.append("<th>Telefono: &nbsp </th>");
        r.append(String.format("<td>%s</td>", this.telefono));
        r.append("</tr>");

        r.append("<tr>");
        r.append("<th>Direccion: &nbsp </th>");
        r.append(String.format("<td>%s</td>", this.direccion));
        r.append("</tr>");

        return r.toString();

    }
}
