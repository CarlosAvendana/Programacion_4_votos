package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Partido;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorPartido implements Serializable {

    private static GestorPartido instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_RECUPERAR
            = "SELECT siglas,nombre,observaciones,bandera "
            + "FROM partido WHERE nombre=? ";

    private static final String CMD_LISTAR
            = "SELECT siglas,nombre,observaciones "
            + "FROM partido ORDER BY siglas; ";

    private static final String CMD_AGREGAR = "INSERT INTO bd_votaciones.partido "
            + "(siglas, nombre, bandera,tipo_imagen, observaciones) "
            + "VALUES(?, ?, ?, ?, ?); ";

    private static final String CMD_VERIFICAR
            = "SELECT siglas,nombre FROM bd_votaciones.partido "
            + "WHERE siglas=? AND nombre=? ";
    
    private static final String CMD_VERIFICAR1
            = "SELECT siglas FROM bd_votaciones.partido "
            + "WHERE siglas=? ";
    
    private static final String CMD_ACTUALIZARS
            = "UPDATE bd_votaciones.partido "
            + "SET siglas=?"
            + "WHERE siglas=?; ";
    
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
//valida la imagen
    public static boolean validate(final String fileName) {
        Matcher matcher = PATTERN.matcher(fileName);
        return matcher.matches();
    }

    private static final String IMAGE_PATTERN
            = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

    private static final Pattern PATTERN = Pattern.compile(IMAGE_PATTERN);
    
    //actualiza las observaciones de partido
    public boolean actualizarO(String observaciones, String s) {
        boolean exito = false;
        try {  
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement("UPDATE bd_votaciones.partido SET observaciones=? Where siglas='" + s + "'");
                stm.clearParameters();
                stm.setString(1, observaciones);
                int r = stm.executeUpdate();
                exito = (r==1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
         return exito;
    }
    
    //actualiza la bandera del partido
    public boolean actualizarB(String s,InputStream in, int size, String contentType) {
        boolean exito = false;
        try {  
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement("UPDATE bd_votaciones.partido SET bandera=?,tipo_imagen=? Where siglas='" + s + "'");
                stm.clearParameters();
                stm.setBinaryStream(1, in,size);
                stm.setString(2, contentType);
                int r = stm.executeUpdate();
                exito = (r==1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
         return exito;
    }
    //actualiza el nombre del partido
    public boolean actualizarN(String nombre, String s) {
        boolean exito = false;
        try {  
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement("UPDATE bd_votaciones.partido SET nombre=? Where siglas='" + s + "'");
                stm.clearParameters();
                stm.setString(1, nombre);
                int r = stm.executeUpdate();
                exito = (r==1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
         return exito;
    }
//agrega un nuevo partido con la foto
    public void agregar(String nombre, String siglas, String observaciones, InputStream in, int size, String contentType) throws SQLException, Exception {
        try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
            PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR);
            stm.clearParameters();
            stm.setString(1, siglas);
            stm.setString(2, nombre);
            stm.setBinaryStream(3, in, size);
            stm.setString(4, contentType);
            stm.setString(5, observaciones);
            int r = stm.executeUpdate();
            if (r == 1) {
                System.out.printf("Se agregó con éxito la imagen: '%s'..%n", nombre);
            } else {
                throw new Exception("No se pudo insertar la imagen seleccionada.");
            }
        }
    }
    //verifica si existe el partido solo por siglas
    public boolean verificarPartido1(String siglas) {
        boolean encontrado = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR1)) {
                stm.clearParameters();
                stm.setString(1, siglas);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return encontrado;
    }
    
    
    //verifica el partido por siglas y nombre
    public boolean verificarPartido(String siglas, String nombre) {
        boolean encontrado = false;
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, siglas);
                stm.setString(2, nombre);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return encontrado;
    }
    
//metodo que no se ocupa la momento
    public Partido recuperar(String nombre) {
        Partido r = null;
//        try {
//            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
//                    PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
//                stm.clearParameters();
//                stm.setString(1, nombre);
//                try (ResultSet rs = stm.executeQuery()) {
//                    if (rs.next()) {
//                        r = new Partido(
//                                rs.getString("siglas"),
//                                rs.getString("nombre"),
//                                rs.getString("observaciones"),
//                                rs.getObject("bandera", int.class)
//                        );
//                    }
//                }
//            }
//        } catch (SQLException ex) {
//            System.err.printf("Excepción: '%s'%n",
//                    ex.getMessage());
//        }
        return r;
    }
//listar los partidos
    public List<Partido> listarTodos() {
        List<Partido> r = new ArrayList<>();
        try {
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE);
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
                while (rs.next()) {
                    r.add(new Partido(
                            rs.getString("siglas"),
                            rs.getString("nombre"),
                            rs.getString("observaciones")
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
