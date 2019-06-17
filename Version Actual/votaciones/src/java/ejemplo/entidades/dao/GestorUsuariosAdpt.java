package ejemplo.entidades.dao;

import Modelo.ListaUsuarios;
import Modelo.Usuario1;


public abstract class GestorUsuariosAdpt implements IGestorUsuarios {

    @Override
    public void agregar(ListaUsuarios usuarios) {
        usuarios.obtenerLista().forEach((u) -> {
            agregar(u);
        });
    }

}
