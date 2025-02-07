package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Votacion;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorVotacion implements Serializable {

    private static GestorVotacion instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_RECUPERAR
            = "SELECT id, fecha_inicio,fecha_apertura, fecha_final, fecha_cierre, estado "
            + "FROM votacion WHERE id=? ";

    private static final String CMD_LISTAR
            = "SELECT id, fecha_inicio, fecha_apertura, fecha_final, fecha_cierre, estado "
            + "FROM votacion ORDER BY id; ";

    private static final String CMD_ACTUALIZAR
            = "UPDATE bd_votaciones.votacion "
            + "SET id=?, fecha_inicio=?,fecha_apertura=?, fecha_final=?, fecha_cierre=?, estado=? ";
    
    private static final String CMD_VERIFICAR
            = "SELECT id FROM votacion "
            + "WHERE id=? ";

    private static final String CMD_AGREGAR = "INSERT INTO bd_votaciones.votacion "
            + "(fecha_inicio, fecha_apertura, fecha_final, fecha_cierre, estado) "
            + "VALUES(?, ?, ?, ?, ?); ";

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
    
    public boolean actualizarE(int o, int s) {
        boolean exito = false;
        try {  
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement("UPDATE bd_votaciones.votacion SET estado=? Where id='" + s + "'");
                stm.clearParameters();
                stm.setInt(1, o);
                int r = stm.executeUpdate();
                exito = (r==1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
         return exito;
    }


    

    //verifica si exsite esa fecha de votacion
     public boolean verificarVotacion(int id) {
        boolean encontrado = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return encontrado;
    }
    
    //lista todas las votaciones
     public List<Votacion> listarTodos() {
        List<Votacion> r = new ArrayList<>();
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
                while (rs.next()) {
                    r.add(new Votacion(
                            rs.getInt("id"),
                            rs.getDate("fecha_inicio"),
                            rs.getDate("fecha_apertura"),
                            rs.getDate("fecha_cierre"),
                            rs.getDate("fecha_final"),
                            rs.getInt("estado")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }



    
    
    //recupera una votacion

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
//actualiza las votaciones*
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
//agrega una votacion nueva
    public void agregar(String fechaInicio, String fechaApertura, String fechaCierre, String fechaFinal, int estado) throws SQLException, Exception {
        try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
            PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR);
            stm.clearParameters();
            stm.setString(1, fechaInicio);
            stm.setString(2, fechaApertura);
            stm.setString(3, fechaCierre);
            stm.setString(4, fechaFinal);
            stm.setInt(5, 0);
            int r = stm.executeUpdate();
            if (r == 1) {
                System.out.printf("Se agregó con éxito la votacion: '%s'..%n", fechaInicio);
            } else {
                throw new Exception("No se agrego");
            }
        }
    }

}
