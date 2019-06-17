package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.VotacionUsuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorVotacionUsuario implements Serializable {

    public GestorVotacionUsuario() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorVotacionUsuario obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorVotacionUsuario();
        }
        return instancia;
    }

    public boolean agregar(VotacionUsuario vU) {
        boolean exito = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR);
                stm.clearParameters();
                stm.setInt(1, vU.getVotId().getId());
                stm.setString(2, vU.getUsuCedula().getCedula());
                stm.setBoolean(3, true);

                int r = stm.executeUpdate();
                exito = (r == 1);
            }

        } catch (SQLException ex) {
            System.err.printf("Hubo un error al agregar: '%s'%n", ex.getMessage());
        }
        return exito;
    }

    public VotacionUsuario recuperar(int id, String cedula) throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        VotacionUsuario r = null;
        GestorVotacion  vp= GestorVotacion.obtenerInstancia();
        GestorUsuario  vu = GestorUsuario.obtenerInstancia();
       
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                stm.setString(2, cedula);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = new VotacionUsuario(
                                vp.recuperar(rs.getInt("votacion_id")),
                                vu.recuperar(rs.getString("usuario_cedula")),
                                rs.getInt("voto_completado")
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

    public List<VotacionUsuario> listaUsuarios() throws InstantiationException, ClassNotFoundException, IllegalAccessException {

        GestorVotacion  vp= GestorVotacion.obtenerInstancia();
        GestorUsuario  vu = GestorUsuario.obtenerInstancia();
       
        List<VotacionUsuario> r = new ArrayList<>();

        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

                while (rs.next()) {
                    r.add(new VotacionUsuario(
                                vp.recuperar(rs.getInt("votacion_id")),
                                vu.recuperar(rs.getString("usuario_cedula")),
                                rs.getInt("voto_completado")
                    ));
                }

            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }

        return r;
    }

    public boolean eliminar(int id, String cedula) {
        boolean exito = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_ELIMINAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                stm.setString(2, cedula);

                int r = stm.executeUpdate();
                exito = (r == 1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return exito;
    }
    
    public boolean actualizarVotosEmitidos(boolean emitido, int id, String cedula) {

        boolean encontrado = false;
        try {

            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR_VOTO_COMPLETADO)) {
                stm.clearParameters();
                stm.setBoolean(1, emitido);
                stm.setInt(2, id);
                stm.setString(3, cedula);
                
                int rs = stm.executeUpdate();
                encontrado = rs == 1;
            }

        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return encontrado;
    }
    
    public int recuperarTotalVotantes(int id) {
        int r = 0;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR_TOTAL_VOTANTES)) {
                stm.clearParameters();
                stm.setInt(1, id);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = rs.getInt("COUNT(*)");
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }
    
    public int recuperarTotalVotosEmitidos(int id) {
        int r = 0;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR_TOTAL_VOTOS_VALIDOS)) {
                stm.clearParameters();
                stm.setInt(1, id);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = rs.getInt("COUNT(*)");
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    private static final String CMD_AGREGAR
            = "INSERT into bd_votaciones.votacion_usuario "
            + "(votacion_id, usuario_cedula, voto_completado) "
            + "VALUES (?, ?, ?) ";

    private static final String CMD_RECUPERAR
            = "SELECT votacion_id, usuario_cedula, voto_completado "
            + "FROM bd_votaciones.votacion_usuario "
            + "WHERE votacion_id=? AND usuario_cedula=?; ";

    private static final String CMD_LISTAR
            = "SELECT votacion_id, usuario_cedula, voto_completado "
            + "FROM bd_votaciones.votacion_usuario "
            + "ORDER BY votacion_id, usuario_cedula ";

    private static final String CMD_ELIMINAR
            = "Delete "
            + "FROM bd_votaciones.votacion_usuario "
            + "WHERE votacion_id=? AND usuario_cedula=?; ";
    
    private static final String CMD_ACTUALIZAR_VOTO_COMPLETADO
            = "UPDATE bd_votaciones.votacion_usuario "
            + "SET voto_completado = ? "
            + "Where votacion_id=? AND usuario_cedula=?; ";
    
    private static final String CMD_RECUPERAR_TOTAL_VOTANTES
            = "SELECT COUNT(*) "
            + "FROM bd_votaciones.votacion_usuario "
            + "WHERE votacion_id=?; ";
    
    private static final String CMD_RECUPERAR_TOTAL_VOTOS_VALIDOS
            = "SELECT COUNT(*) "
            + "FROM bd_votaciones.votacion_usuario "
            + "WHERE votacion_id=? AND voto_completado=1; ";

    private static GestorVotacionUsuario instancia = null;
    private final GestorBaseDeDatos bd;
}
