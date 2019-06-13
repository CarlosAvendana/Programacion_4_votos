package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.VotacionPartido;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorVotacionPartido implements Serializable {

    private static GestorVotacionPartido instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_RECUPERAR
            = "SELECT votacion_id,partido_siglas, cedula_candidato, foto_candidato,votos_obtenidos "
            + "FROM votacion_partido WHERE votacion_id=? ";

    private static final String CMD_LISTAR
            = "SELECT votacion_id,partido_siglas, cedula_candidato, foto_candidato,votos_obtenidos"
            + "FROM votacion_partido ORDER BY votacion_id; ";

    private static final String CMD_ACTUALIZAR
            = "UPDATE bd_votaciones.votacion_partido "
            + "SET votacion_id=?,partido_siglas=?, cedula_candidato=?, foto_candidato=?,votos_obtenidos=? ";

    private static final String CMD_AGREGAR = "INSERT INTO  "
            + "(votacion_id, partido_siglas, cedula_candidato, foto_candidato, votos_obtenidos) "
            + "VALUES(?, ?, ?, ?, ?); ";

    private static final String CONEXION
            = "jdbc:mysql://localhost/bd_votaciones";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    private GestorVotacionPartido() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorVotacionPartido obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorVotacionPartido();
        }
        return instancia;
    }

    public VotacionPartido recuperar(String codigo) throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        VotacionPartido r = null;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setString(1, codigo);
                try (ResultSet rs = stm.executeQuery()) {
                    GestorVotacion gv = GestorVotacion.obtenerInstancia();
                    GestorPartido gp = GestorPartido.obtenerInstancia();
                    GestorUsuario gu = GestorUsuario.obtenerInstancia();
                    if (rs.next()) {
                        r = new VotacionPartido(
                                gv.recuperar("votacion_id"),
                                gp.recuperar("partido_siglas"),
                                gu.recuperar("cedula_candidato"),
                                rs.getString("foto_candidato"),
                                rs.getInt("votos_obtenidos")
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
