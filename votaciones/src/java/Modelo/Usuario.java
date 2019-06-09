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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


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
    //-.-.-.- Edicion para beans
    
    public static Usuario fromArray(ArrayList<String> datos) throws ParseException {
        String i = datos.get(0);
        String ap1 = datos.get(1);
        String ap2 = datos.get(2);
        String n = datos.get(3);
        String cl   = datos.get(4);
        String ac = datos.get(5);
        int a = Integer.parseInt(ac);
        return new Usuario(i, ap1, ap2, n, cl, a );
    }

    public List<Object> toArray() {
        List<Object> r = new ArrayList<>();
        r.add(getCedula());
        r.add(getApellido1());
        r.add(getApellido2());
        r.add(getNombre());
        r.add(getClave());
        r.add(getActivo());
        return r;
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<tr>");
        r.append("<th>ID: &nbsp </th>");
        r.append(String.format("<td>%s</td>", this.cedula));
        r.append("</tr>");

        r.append("<tr>");
        r.append("<th>Nombre  Completo: &nbsp </th>");
        r.append(String.format("<td>%s</td><td>%s</td><td>%s</td>", this.nombre, this.apellido1, this.apellido2));
        r.append("</tr>");
        return r.toString();

    }
    
}
