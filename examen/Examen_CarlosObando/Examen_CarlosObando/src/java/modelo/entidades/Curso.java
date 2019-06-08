package modelo.entidades;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Curso {

    String codigo;
    String nombre;
    String creditos;

    public Curso(String codigo, String nombre, String creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Curso() {
        this(null, null, null);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return String.format(
                "{%s, %s, %s}",
                codigo, nombre, creditos);
    }

    public List<Object> toArray() {
        List<Object> r = new ArrayList<>();
        r.add(this.getCodigo());
        r.add(this.getNombre());
        r.add(this.getCreditos());

        return r;
    }

    public static Curso fromArray(ArrayList<String> datos) throws ParseException {

        String codigo1 = datos.get(0);
        String nombre1 = datos.get(1);
        String creditos1 = datos.get(2);

        return new Curso(codigo1, nombre1, creditos1);
    }
}
