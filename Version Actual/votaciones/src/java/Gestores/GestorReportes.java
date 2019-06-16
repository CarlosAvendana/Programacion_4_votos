package Gestores;
//  GestorReportes.java
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Reporte;
import Modelo.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorReportes implements Serializable {

    private static GestorReportes instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_LISTAR
            = "SELECT votacion_id, partido_siglas,cedula_candidato,votos_obtenidos FROM bd_votaciones.votacion_partido; ";

    private static final String CMD_AGREGAR = "INSERT INTO bd_votaciones.partido "
            + "(siglas, nombre, bandera,tipo_imagen, observaciones) "
            + "VALUES(?, ?, ?, ?, ?); ";

    private static final String CMD_VOTOS_NO_EFECTIVOS = "SELECT count(bd_votaciones.votacion_usuario.usuario_cedula) as voto_noEfectivo,\n"
            + "(SELECT count(bd_votaciones.votacion_usuario.usuario_cedula) *100 / count(bd_votaciones.usuario.cedula)\n"
            + "FROM bd_votaciones.votacion_partido,bd_votaciones.usuario )as porcentaje \n"
            + "FROM bd_votaciones.votacion_usuario Where bd_votaciones.votacion_usuario.voto_completado=0;";

    private static final String CMD_VOTOS_EFECTIVOS = "SELECT count(bd_votaciones.votacion_usuario.usuario_cedula) as voto_efectivo,\n"
            + "(SELECT count(bd_votaciones.votacion_usuario.usuario_cedula) *100 / count(bd_votaciones.usuario.cedula)\n"
            + "FROM bd_votaciones.votacion_partido,bd_votaciones.usuario )as porcentaje \n"
            + "FROM bd_votaciones.votacion_usuario;";

    private static final String CMD_CANDIDATOS = "SELECT\n"
            + "bd_votaciones.votacion_partido.votos_obtenidos as votos,\n"
            + "((select bd_votaciones.votacion_partido.votos_obtenidos)*100 / (SELECT count(bd_votaciones.votacion_usuario.usuario_cedula) from bd_votaciones.votacion_usuario where bd_votaciones.votacion_usuario.voto_completado=1 ) ) as porcentaje,\n"
            + "bd_votaciones.votacion_partido.partido_siglas as partido,\n"
            + "bd_votaciones.usuario.nombre\n"
            + "FROM bd_votaciones.votacion_partido,bd_votaciones.usuario where bd_votaciones.usuario.cedula = bd_votaciones.votacion_partido.cedula_candidato;";

    private static final String CMD_VOTANTES_REGISTRADOS = "SELECT COUNT(usuario_cedula) as votantes_registrados from bd_votaciones.votacion_usuario where voto_completado=1;";

    private GestorReportes() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorReportes obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorReportes();
        }
        return instancia;
    }

    public List<Reporte> listarCandidatos() {
        List<Reporte> r = new ArrayList<>();
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_CANDIDATOS)) {
                while (rs.next()) {
                    r.add(new Reporte(
                            rs.getInt("votos"),
                            rs.getFloat("porcentaje"),
                            rs.getString("partido"),
                            rs.getString("nombre")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    public List<Reporte> listar_votoEfectivo() {
        List<Reporte> r = new ArrayList<>();
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_VOTOS_EFECTIVOS)) {
                while (rs.next()) {
                    r.add(new Reporte(
                            rs.getInt("voto_efectivo"),
                            rs.getFloat("porcentaje")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    public List<Reporte> listar_NOvotoEfectivo() {
        List<Reporte> r = new ArrayList<>();
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_VOTOS_NO_EFECTIVOS)) {
                while (rs.next()) {
                    r.add(new Reporte(
                            rs.getInt("voto_noEfectivo"),
                            rs.getFloat("porcentaje")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    public List<Reporte> listar_VotantesRegistrados() {
        List<Reporte> r = new ArrayList<>();
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_VOTANTES_REGISTRADOS)) {
                while (rs.next()) {
                    r.add(new Reporte(
                            rs.getInt("votantes_registrados")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    public List<Reporte> listarTodos() {
        List<Reporte> r = new ArrayList<>();
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
                while (rs.next()) {
                    r.add(new Reporte(
                            rs.getInt("votacion_id"),
                            rs.getString("partido_siglas"),
                            rs.getString("cedula_candidato"),
                            rs.getInt("votos_obtenidos")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

}
