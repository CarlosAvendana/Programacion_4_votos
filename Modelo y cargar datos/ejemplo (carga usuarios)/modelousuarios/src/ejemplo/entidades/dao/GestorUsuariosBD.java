package ejemplo.entidades.dao;

import cr.ac.database.managers.DBManager;
import ejemplo.entidades.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GestorUsuariosBD extends GestorUsuariosAdpt implements IGestorUsuarios {

    private GestorUsuariosBD() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException,
            IOException {
        configuracion = new Properties();
        configuracion.load(GestorUsuariosBD.class.getResourceAsStream(ARCHIVO_CONFIGURACION));
        bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
    }

    @Override
    public void agregar(Usuario nuevoUsuario) {
        try {
            try (Connection cnx = obtenerConexion();
                    PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setString(1, nuevoUsuario.getCedula());
                stm.setString(2, nuevoUsuario.getApellido1());
                stm.setString(3, nuevoUsuario.getApellido2());
                stm.setString(4, nuevoUsuario.getNombre());
                stm.setString(5, nuevoUsuario.getClave());
                stm.setBoolean(6, nuevoUsuario.isActivo());
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No se puede agregar el registro: '%s'", nuevoUsuario));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    @Override
    public void inicializar() {
        throw new UnsupportedOperationException("GestorUsuariosBD.inicializar()");
    }

    @Override
    public List<Usuario> obtenerLista() {
        List<Usuario> r = new ArrayList<>();
        try {
            Connection cnx = obtenerConexion();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(CMD_LISTAR);
            while (rs.next()) {
                r.add(new Usuario(
                        rs.getString("cedula"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("nombre"),
                        rs.getString("clave"),
                        rs.getBoolean("activo")
                ));
            }
            rs.close();
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public static IGestorUsuarios obtenerInstancia() {
        if (instancia == null) {
            try {
                instancia = new GestorUsuariosBD();
            } catch (IOException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException ex) {
                System.err.printf("", ex.getMessage());
            }
        }
        return instancia;
    }

    @Override
    public String obtenerDescripcion() {
        return "gestor de usuarios (base de datos)";
    }

    public Connection obtenerConexion() throws SQLException {

        Connection cnx;

        try {
            System.out.println("Intentando la conexión con el servidor de aplicaciones..");

            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(CNX_SERVIDOR);
            cnx = ds.getConnection();

        } catch (NamingException ex) {

            System.err.printf("No es posible conectarse con el servidor: '%s'%n", ex.getMessage());
            System.out.println("Intentando conexión directa con el servidor de base de datos..");

            cnx = bd.getConnection(
                    configuracion.getProperty("database"),
                    configuracion.getProperty("user"),
                    configuracion.getProperty("password"));
        }

        return cnx;
    }

    private static IGestorUsuarios instancia = null;
    private final Properties configuracion;
    private final DBManager bd;

    private static final String CNX_SERVIDOR = "jdbc/?";
    private static final String ARCHIVO_CONFIGURACION = "usuarios.properties";
    private static final String CMD_LISTAR
            = "SELECT cedula, apellido1, apellido2, nombre, clave, activo "
            + "FROM usuario "
            + "ORDER BY apellido1, apellido2, nombre, cedula; ";
    private static final String CMD_AGREGAR
            = "INSERT INTO usuario "
            + "(cedula, apellido1, apellido2, nombre, clave, activo) "
            + "VALUES (?, ?, ?, ?, ?, ?); ";
}
