
package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuario implements Serializable{
    private static GestorUsuario instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_RECUPERAR
            = "SELECT cedula,nombre,apellido1,apellido2,contraseña,voto "
            + "FROM usuario WHERE cedula=? ";

    private static final String CMD_VERIFICAR
            = "SELECT cedula FROM usuario "
            + "WHERE cedula=? AND contraseña=? ";

    private static final String CMD_LISTAR
            = "SELECT id,nombre,apellido,clave,ultimo_acceso,estado,activo,grupo_id "
            + "FROM estudiante ORDER BY nombre; ";

    private static final String CMD_ACTUALIZAR
            = "UPDATE gruposdb.estudiante "
            + "SET id=?,nombre=?,apellido=?,clave=?,ultimo_acceso=?,estado=?,activo=?,grupo_id=? ";

    private static final String CMD_AGREGAR = "INSERT INTO estudiante "
            + "(id, nombre, apellido, clave, ultimo_acceso, estado,activo, grupo_id) "
            + "VALUES(?, ?, ?, ?, ?, ?,?, ?); ";

    private static final String CMD_LISTAR_ESTUXGRUP = "select g.nombre, e.nombre, e.apellido "
            + "from grupo g, estudiante e "
            + "where e.grupo_id = g_id and g.id = ?; ";

    private static final String CONEXION
            = "jdbc:mysql://localhost/votosdb";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    private GestorUsuario() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorUsuario obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorUsuario();
        }
        return instancia;
    }

    public Usuario recuperar(String codigo) {
        Usuario r = null;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setString(1, codigo);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = new Usuario(
                                rs.getString("cedula"),
                                rs.getString("nombre"),
                                rs.getString("apellido1"),
                                rs.getString("apellido2"),
                                rs.getString("contraseña"),
                                rs.getInt("voto")   
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
    
    public boolean verificarUsuario(String cedula, String contraseña) {
        boolean encontrado = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, cedula);
                stm.setString(2, contraseña);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return encontrado;
    }
    
    
   
}
