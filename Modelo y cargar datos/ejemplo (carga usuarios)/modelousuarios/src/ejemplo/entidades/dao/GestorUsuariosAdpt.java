package ejemplo.entidades.dao;

import ejemplo.entidades.ListaUsuarios;

public abstract class GestorUsuariosAdpt implements IGestorUsuarios {

    @Override
    public void agregar(ListaUsuarios usuarios) {
        usuarios.obtenerLista().forEach((u) -> {
            agregar(u);
        });
    }

}
