package ejemplo.entidades.dao;

import ejemplo.entidades.ListaUsuarios;
import ejemplo.entidades.Usuario;
import java.util.List;

public interface IGestorUsuarios {

    void agregar(Usuario nuevoUsuario);

    void agregar(ListaUsuarios usuarios);

    void inicializar();

    List<Usuario> obtenerLista();

    String obtenerDescripcion();

}
