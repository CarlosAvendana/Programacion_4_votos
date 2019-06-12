
package Gestores;

import Modelo.Administrador;
import cr.ac.database.managers.DBManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GAdmi2 {
    
    private static GAdmi2 instancia = null;
    private DBManager db = null;
    private static final String BASE_DATOS = "bd_votaciones";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String CMD_LISTAR
             = "SELECT cedula,apellido1,apellido2,nombre,usuario FROM administrador;";

    private GAdmi2() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        db = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
    }

    public static GAdmi2 obtenerInstancia()
            throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        if (instancia == null) {
            instancia = new GAdmi2();
        }
        return instancia;
    }

    public List<Administrador> obtenerLista() throws SQLException {
        List<Administrador> r = new ArrayList<>();

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
        List<Administrador> registros = obtenerLista();
        registros.forEach((registro) -> {
            if (registro.getUsuario()== null ? id == null : registro.getUsuario().equals(id)) {
                r.append(registro.toStringHTML());
            }
        });
        return r.toString();
    }
    
}
