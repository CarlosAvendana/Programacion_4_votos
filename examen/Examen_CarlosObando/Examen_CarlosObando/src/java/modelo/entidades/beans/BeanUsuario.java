package modelo.entidades.beans;

import java.io.Serializable;
import modelo.entidades.dao.GestorUsuarios;
import modelo.entidades.Usuario;

public class BeanUsuario implements Serializable {

    private Usuario usuarioActual = null;
    private boolean valido = false;
    private static final int MIN_PRIORIDAD = 99;

    public BeanUsuario() {
        usuarioActual = new Usuario();
        valido = false;
    }

    public boolean getValido() {
        return valido;
    }

    protected void setValido(boolean nuevoEstado) {
        valido = nuevoEstado;
    }

    public String getNombre() {
        return usuarioActual.getNombre();
    }

    public void setNombre(String nombre) {
        usuarioActual.setNombre(nombre);
    }

    public String getEstado() {
        return (getValido()) ? "válido" : "inválido";
    }

    public void validar(String nombre, String clave) {
        GestorUsuarios g = new GestorUsuarios("localhost");
        if (g.verificarUsuario(nombre, clave)) {
            setNombre(nombre);
            setValido(true);
        } else {
            setValido(false);
        }
    }

    public static void validar(BeanUsuario instancia,
            String nombre, String clave) {
        instancia.validar(nombre, clave);
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", usuarioActual, getEstado());
    }

}
