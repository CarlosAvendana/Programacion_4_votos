package Servicios;

import ejemplo.entidades.dao.*;

public class AdministradorGestor {

    private AdministradorGestor() {
        gestor = GestorUsuariosBD.obtenerInstancia();
    }

    public static AdministradorGestor obtenerInstancia() {
        if (instancia == null) {
            instancia = new AdministradorGestor();
        }
        return instancia;
    }

    public IGestorUsuarios obtenerGestor() {
        return gestor;
    }

    private static AdministradorGestor instancia = null;
    private final IGestorUsuarios gestor;
}
