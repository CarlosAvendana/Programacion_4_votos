
package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Partido;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GestorPartido implements Serializable {
    
    private static GestorPartido instancia = null;
    private final GestorBaseDeDatos bd;
    
    private static final String CMD_RECUPERAR
            = "SELECT siglas,nombre,observaciones,bandera "
            + "FROM partido WHERE nombre=? ";
    
    private static final String CMD_LISTAR
            = "SELECT siglas,nombre,observaciones,bandera "
            + "FROM partido ORDER BY nombre; ";
    
    private static final String CMD_AGREGAR = "INSERT INTO partido "
            + "(siglas, nombre, observaciones, bandera) "
            + "VALUES(?, ?, ?, ?); ";
    
    
    private GestorPartido() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorPartido obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorPartido();
        }
        return instancia;
    }
    
    
    public Partido recuperar(String nombre) {
        Partido r = null;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setString(1, nombre);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = new Partido(
                                rs.getString("siglas"),
                                rs.getString("nombre"),
                                rs.getString("observaciones"),
                                rs.getBlob("bandera")
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
    
    
    
    
}
