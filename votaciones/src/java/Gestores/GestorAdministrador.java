package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
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

public class GestorAdministrador implements Serializable {

    private static GestorAdministrador instancia = null;
    private final GestorBaseDeDatos bd;
    private final DBManager db = null;

    private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "bd_votaciones";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String CMD_LISTAR = "SELECT cedula, apellido1,apellido2,nombre,usuario "
            + "FROM bd_votaciones.administrador "
            + "order by cedula;";

    private static final String CMD_RECUPERAR
            = "SELECT cedula,apellido1,apellido2,nombre,usuario,clave "
            + "FROM administrador WHERE cedula=? ";

    private static final String CMD_VERIFICAR
            = "SELECT usuario FROM administrador "
            + "WHERE usuario=? AND clave=? ";

  
    private GestorAdministrador() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
       
    }

    public static GestorAdministrador obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorAdministrador();
        }
        return instancia;
    }

    public List<Administrador> obtenerLista() throws SQLException {

        List<Administrador> lista = new ArrayList<>();

        try (Connection cnx = db.getConnection(BASE_DATOS, LOGIN, PASSWORD);
                Statement stm = cnx.createStatement(); ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            String cedula, nombre, apellido1, apellido2, usuario;

            while (rs.next()) {

                cedula = rs.getString("cedula");
                nombre = rs.getString("nombre");
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                usuario = rs.getString("usuario");
                lista.add(new Administrador(cedula, nombre, apellido1, apellido2, usuario));
            }
        }
        return lista;
    }

    public Administrador recuperar(String codigo) {
        Administrador r = null;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setString(1, codigo);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = new Administrador(
                                rs.getString("cedula"),
                                rs.getString("apellido1"),
                                rs.getString("apellido2"),
                                rs.getString("nombre"),
                                rs.getString("usuario"),
                                rs.getString("clave")
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    public boolean verificarAdministrador(String usuario, String clave) {
        boolean encontrado = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, usuario);
                stm.setString(2, clave);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return encontrado;
    }

    public String obtenerDatosHTML(Object objeto) throws SQLException {
        String id = (String) objeto;
        StringBuilder r = new StringBuilder();
        List<Administrador> registros = obtenerLista();
        registros.forEach((registro) -> {
            if (registro.getUsuario() == null ? id == null : registro.getUsuario().equals(id)) {
                r.append(registro.toStringHTML());
            }
        });
        return r.toString();
    }

}
