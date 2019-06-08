package modelo.entidades.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Curso;

public class GestorCursos implements Serializable {

    private static final String DATABASE_DRIVER
            = "com.mysql.cj.jdbc.Driver";

    private static final String CONEXION
            = "jdbc:mysql://localhost/eif209_prc1";
    private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "eif209_prc1";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    private static final String CMD_LISTAR
            = "SELECT codigo, nombre,creditos "
            + "FROM eif209_prc1.curso "
            + "ORDER BY codigo; ";

    private static GestorCursos instancia = null;

    public GestorCursos() {
        try {
            Class.forName(DATABASE_DRIVER).newInstance();
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static GestorCursos obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCursos();
        }
        return instancia;
    }

    public List<Curso> listarTodos() {
        List<Curso> r = new ArrayList<>();

        try (Connection cnx = DriverManager.getConnection(
                CONEXION, USUARIO, CLAVE);
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int creditos = rs.getInt("creditos");
                String cre = Integer.toString(creditos);
                r.add(new Curso(codigo, nombre, cre));
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public String getTablaHTML() {
        StringBuilder r = new StringBuilder();
        List<Curso> cursos = listarTodos();
        for (Curso p : cursos) {
            r.append("<style=\"text-align: center\" tr>");
            r.append(String.format(
                    "<td style=\"text-align: center\">%s</td><td style=\"text-align: left\">%s</td><td style=\"text-align: center\">%s</td>",
                    p.getCodigo(), p.getNombre(), p.getCreditos()));
            r.append("</tr>");
        }
        return r.toString();
    }

}
