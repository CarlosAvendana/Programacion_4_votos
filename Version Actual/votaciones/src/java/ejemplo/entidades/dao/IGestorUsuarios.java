package ejemplo.entidades.dao;



import Modelo.ListaUsuarios;
import Modelo.Usuario1;
import java.util.List;

public interface IGestorUsuarios {

    void agregar(Usuario1 nuevoUsuario);

    void agregar(ListaUsuarios usuarios);

    void inicializar();

    List<Usuario1> obtenerLista();

    String obtenerDescripcion();

}
