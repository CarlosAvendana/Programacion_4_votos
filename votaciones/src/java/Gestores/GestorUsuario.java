
package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorUsuario implements Serializable{
    private static GestorUsuario instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_RECUPERAR
            = "SELECT cedula,apellido1,apellido2,nombre,clave,activo "
            + "FROM usuario WHERE cedula=? ";

    private static final String CMD_VERIFICAR
            = "SELECT cedula FROM Usuario "
            + "WHERE cedula=? AND clave=? ";

    private static final String CMD_LISTAR
            = "SELECT cedula, apellido1 ,apellido2, nombre, clave ,activo "
            + "FROM estudiante ORDER BY apellido1; ";

    private static final String CMD_ACTUALIZAR
            = "UPDATE bd_votaciones.usuario "
            + "SET cedula=?,apellido1=?,apellido2=?, nombre=?,clave=?, activo=? ";

    private static final String CMD_AGREGAR = "INSERT INTO usuario "
            + "(cedula, apellido1, apellido2, nombre, clave,activo) "
            + "VALUES(?, ?, ?, ?, ?, ?); ";

    private static final String CONEXION
            = "jdbc:mysql://localhost/bd_votaciones";
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
                                rs.getString("apellido1"),
                                rs.getString("apellido2"),
                                rs.getString("nombre"),
                                rs.getString("clave"),
                                rs.getInt("activo")   
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
    
    public boolean verificarUsuario(String cedula, String clave) {
        boolean encontrado = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, cedula);
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
    
    
    public boolean actualizar(Usuario u){
         boolean exito = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement("UPDATE bd_votaciones.usuario SET cedula=?,apellido1=?, apellido2=?, nombre=? ,clave=?, activo =? Where cedula='" + u.getCedula() + "'");
                stm.clearParameters();
                stm.setString(1, u.getCedula());
                stm.setString(2, u.getApellido1());
                stm.setString(3, u.getApellido2());
                stm.setString(4, u.getNombre());
                stm.setString(5, u.getClave());
                stm.setInt(6, u.getActivo());
                int r;
                r = stm.executeUpdate();
                if (r == 1) {
                    exito = true;
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return exito;
        
    }    
   
}
