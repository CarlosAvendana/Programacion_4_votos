package ejemplo.entidades.dao;

import ejemplo.entidades.Usuario;
import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class GestorUsuarios extends GestorUsuariosAdpt implements Serializable {

    private GestorUsuarios() {
        usuarios = new HashMap<>();
    }

    @Override
    public List<Usuario> obtenerLista() {
        List<Usuario> r = new ArrayList<>(usuarios.values());

        Collator c = Collator.getInstance(new Locale("es"));

        Collections.sort(r, (Usuario o1, Usuario o2) -> {
            int r1 = c.compare(o1.getApellido1(), o2.getApellido1());
            if (r1 == 0) {
                r1 = c.compare(o1.getApellido2(), o2.getApellido2());
                if (r1 == 0) {
                    r1 = c.compare(o1.getNombre(), o2.getNombre());
                    if (r1 == 0) {
                        r1 = o1.getCedula().compareTo(o2.getCedula());
                    }
                }
            }
            return r1;
        });
        return r;
    }

    @Override
    public void inicializar() {
        usuarios.clear();
    }

    @Override
    public void agregar(Usuario nuevoUsuario) {
        if (!usuarios.containsKey(nuevoUsuario.getCedula())) {
            usuarios.put(nuevoUsuario.getCedula(), nuevoUsuario);
        } else {
            throw new IllegalArgumentException(
                    String.format("El usuario '%s' ya está incluido en la tabla..",
                            nuevoUsuario.getCedula()));
        }
    }

    public static IGestorUsuarios obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    @Override
    public String obtenerDescripcion() {
        return "gestor de usuarios (HashMap)";
    }

    private static IGestorUsuarios instancia = null;
    private final HashMap<String, Usuario> usuarios;
}
