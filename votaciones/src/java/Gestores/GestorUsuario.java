
package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuario {
    private static GestorUsuario instancia = null;
    private final GestorBaseDeDatos bd;

    private static final String CMD_RECUPERAR
            = "SELECT id,nombre,apellido,clave,ultimo_acceso,estado,activo,grupo_id "
            + "FROM estudiante WHERE id=? ";

    private static final String CMD_VERIFICAR
            = "SELECT id FROM estudiante "
            + "WHERE id=? AND clave=? ";

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
            = "jdbc:mysql://localhost/gruposdb";
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

   
}
