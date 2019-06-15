package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Votacion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorVotacion implements Serializable {

    private static GestorVotacion instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_RECUPERAR
            = "SELECT id, fecha_inicio,fecha_apertura, fecha_final, fecha_cierre, estado "
            + "FROM votacion WHERE id=? ";

    private static final String CMD_LISTAR
            = "SELECT id, fecha_inicio,fecha_apertura, fecha_final, fecha_cierre, estado "
            + "FROM votacion ORDER BY id; ";

    private static final String CMD_ACTUALIZAR
            = "UPDATE bd_votaciones.votacion "
            + "SET id=?, fecha_inicio=?,fecha_apertura=?, fecha_final=?, fecha_cierre=?, estado=? ";

    private static final String CMD_AGREGAR = "INSERT INTO votacion "
            + "(id, fecha_inicio, fecha_apertura, fecha_final, fecha_cierre, estado) "
            + "VALUES(?, ?, ?, ?, ?, ?); ";

    private static final String CONEXION
            = "jdbc:mysql://localhost/bd_votaciones";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    private GestorVotacion() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorVotacion obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorVotacion();
        }
        return instancia;
    }

    public Votacion recuperar(int codigo) {
        Votacion r = null;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, codigo);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = new Votacion(
                                rs.getInt("id"),
                                rs.getDate("fecha_inicio"),
                                rs.getDate("fecha_apertura"),
                                rs.getDate("fecha_cierre"),
                                rs.getDate("fecha_final"),
                                rs.getInt("estado")
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

    public boolean actualizar(Votacion u) {
        boolean exito = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement("UPDATE bd_votaciones.votacion SET fecha_inicio=?, fecha_apertura=?, fecha_cierre=?, fecha_final=?, estado =? Where id='" + u.getId() + "'");
                stm.clearParameters();
                stm.setInt(1, u.getId());
                stm.setDate(2, u.getFechaInicio());
                stm.setDate(3, u.getFechaApertura());
                stm.setDate(4, u.getFechaCierre());
                stm.setDate(5, u.getFechaFinal());
                stm.setInt(6, u.getEstado());
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
