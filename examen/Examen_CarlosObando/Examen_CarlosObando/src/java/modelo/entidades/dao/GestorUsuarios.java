package modelo.entidades.dao;

import cr.ac.database.managers.DBManager;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Usuario;

public class GestorUsuarios implements Serializable {

    private static GestorUsuarios instancia = null;
    private DBManager db = null;

    private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "eif209_prc1";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String CMD_LISTAR
            = "SELECT id, apellido1, apellido2, nombre, email, clave, telefono, direccion"
            + "FROM usuarios ORDER BY id ";

    private static final String CMD_VERIFICAR
            = "SELECT id FROM estudiante "
            + "WHERE id=? AND clave=? ";

    public GestorUsuarios(String nuevoServidor) {
        this.URL_Servidor = nuevoServidor;
    }

    private GestorUsuarios() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        db = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
        this.URL_Servidor = "localhost";
    }

    public static GestorUsuarios obtenerInstancia()
            throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public ArrayList<Object[]> obtenerLista() {
        ArrayList<Object[]> usuarios = new ArrayList<>();
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(CMD_LISTAR);
            int maxCols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] registro = new Object[maxCols];
                for (int i = 0; i < maxCols; i++) {
                    registro[i] = rs.getObject(i + 1);
                }
                usuarios.add(registro);
            }
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            bd.closeConnection();
        }

        return usuarios;
    }

    public static String listaUsuariosHTML(GestorUsuarios g) {
        StringBuilder r = new StringBuilder();
        ArrayList<Object[]> usuarios = g.obtenerLista();
        if (usuarios.size() > 0) {
            for (Object[] registro : usuarios) {
                r.append("<tr>");
                for (Object e : registro) {
                    r.append("<td>");
                    if (e != null) {
                        r.append(e.toString());
                    } else {
                        r.append("(null)");
                    }
                    r.append("</td>");
                }
                r.append("</tr>");
            }
        } else {
            r.append("<tr><td colspan=\"5\">(No hay registros en la base de datos.)</td></tr>");
        }

        return r.toString();
    }

    public boolean verificarUsuario(String usuario, String clave) {

        boolean encontrado = false;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, usuario);
                stm.setString(2, clave);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            if (bd != null) {
                bd.closeConnection();
            }
        }
        return encontrado;
    }

    public void setUrlServidor(String nuevoURL) { // urlServidor
        URL_Servidor = nuevoURL;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public List<Usuario> obtenerLista2() throws SQLException {
        List<Usuario> r = new ArrayList<>();
        DBManager db = null;
        try (Connection cnx = db.getConnection(BASE_DATOS, LOGIN, PASSWORD);
                Statement stm = cnx.createStatement(); ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            String id, apellido1, apellido2, nombre, email, clave, telefono, direccion;

            while (rs.next()) {
                id = rs.getString("id");
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                nombre = rs.getString("nombre");
                email = rs.getString("email");
                clave = rs.getString("clave");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");

                r.add(new Usuario(id, apellido1, apellido2, nombre, email,
                        clave, telefono, direccion));
            }
        }
        return r;
    }

    public String obtenerDatosHTML(Object objeto) throws SQLException {
        String id = (String) objeto;
        StringBuilder r = new StringBuilder();
        List<Usuario> registros = obtenerLista2();
        registros.forEach((registro) -> {
            if (registro.getId() == null ? id == null : registro.getId().equals(id)) {
                r.append(registro.toStringHTML());
            }
        });
        return r.toString();
    }
}
