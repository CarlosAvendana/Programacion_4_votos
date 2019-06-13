package Gestores;

import Modelo.Administrador;
import cr.ac.database.managers.DBManager;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GAdmi implements Serializable {

    private static GAdmi instancia = null;
    private DBManager db = null;

    private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "bd_votaciones";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String CMD_LISTAR
            = "SELECT cedula,apellido1,apellido2,nombre,usuario FROM administrador;";

    private static final String CMD_VERIFICAR
            = "SELECT usuario FROM administrador "
            + "WHERE usuario=? AND clave=? ";

    public GAdmi(String nuevoServidor) {
        this.URL_Servidor = nuevoServidor;
    }

    private GAdmi() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        db = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
        this.URL_Servidor = "localhost";
    }

    public static GAdmi obtenerInstancia()
            throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        if (instancia == null) {
            instancia = new GAdmi();
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

    public static String listaUsuariosHTML(GAdmi g) {
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

    public List<Administrador> obtenerLista2() throws SQLException {
        List<Administrador> r = new ArrayList<>();
        DBManager db = null;
        try (Connection cnx = db.getConnection(BASE_DATOS, LOGIN, PASSWORD);
                Statement stm = cnx.createStatement(); ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            String cedula, nombre, apellido1, apellido2, usuario;
            while (rs.next()) {
                cedula = rs.getString("cedula");
                nombre = rs.getString("nombre");
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                usuario = rs.getString("usuario");
                r.add(new Administrador(cedula, nombre, apellido1, apellido2, usuario));
            }
        }
        return r;
    }

    public String obtenerDatosHTML(Object objeto) throws SQLException {
        String id = (String) objeto;
        StringBuilder r = new StringBuilder();
        List<Administrador> registros = obtenerLista2();
        registros.forEach((registro) -> {
            if (registro.getUsuario() == null ? id == null : registro.getUsuario().equals(id)) {
                r.append(registro.toStringHTML());
            }
        });
        return r.toString();
    }

}
