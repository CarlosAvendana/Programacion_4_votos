package modelo.entidades.dao;

import cr.ac.database.managers.DBManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Estudiante;

public class GestorEstudiante {

    private static GestorEstudiante instancia = null;
    private DBManager db = null;
    private static final String BASE_DATOS = "eif209_prc1";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String CMD_LISTAR
            = "SELECT `id`, `apellido1`, `apellido2`, `nombre`, `email`,"
            + "`clave`, `telefono`, `direccion`"
            + "FROM  `eif209_prc1`.`estudiante` ORDER BY `id`";

    private GestorEstudiante() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        db = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
    }

    public static GestorEstudiante obtenerInstancia()
            throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorEstudiante();
        }
        return instancia;
    }

    public List<Estudiante> obtenerLista() throws SQLException {
        List<Estudiante> r = new ArrayList<>();

        try (Connection cnx = db.getConnection(BASE_DATOS, LOGIN, PASSWORD);
                Statement stm = cnx.createStatement(); ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            String id, apellido1, apellido2, nombre, email2, clave2, telefono2, direccion2;

            while (rs.next()) {
                id = rs.getString("id");
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                nombre = rs.getString("nombre");
                email2 = rs.getString("email");
                clave2 = rs.getString("clave");
                telefono2 = rs.getString("telefono");
                direccion2 = rs.getString("direccion");

                r.add(new Estudiante(id, apellido1, apellido2, nombre, email2,
                        clave2, telefono2, direccion2));
            }
        }
        return r;
    }

    public String obtenerDatosHTML(Object objeto) throws SQLException {
        String id = (String) objeto;
        StringBuilder r = new StringBuilder();
        List<Estudiante> registros = obtenerLista();
        registros.forEach((registro) -> {
            if (registro.getId() == null ? id == null : registro.getId().equals(id)) {
                r.append(registro.toStringHTML());
            }
        });
        return r.toString();
    }
}
