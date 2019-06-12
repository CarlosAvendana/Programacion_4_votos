/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import GestorSQL.GestorBaseDeDatos;
import Modelo.Credenciales;
import Modelo.Usuario;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author demil
 */
public class GestorXML implements Serializable{
    
    private static GestorXML instancia = null;
    private final GestorBaseDeDatos bd;
    
    private static final String CMD_AGREGAR = "INSERT INTO usuario "
            + "(cedula, apellido1, apellido2, nombre, clave,activo) "
            + "VALUES(?, ?, ?, ?, ?, ?); ";
    
    
    
    public boolean agregarAlaBD(Usuario nuevoUsuario) {
        boolean exito = false;
        try {  
            try (Connection cnx = bd.obtenerConexion(Credenciales.BASE_DATOS, Credenciales.USUARIO, Credenciales.CLAVE)) {
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR);
                stm.clearParameters();
                stm.setString(1, nuevoUsuario.getCedula());
                stm.setString(2, nuevoUsuario.getApellido1());
                stm.setString(3, nuevoUsuario.getApellido2());
                stm.setString(4, nuevoUsuario.getNombre());
                stm.setString(5, nuevoUsuario.getClave());
                stm.setInt(5, nuevoUsuario.getActivo());
                int r = stm.executeUpdate();
                exito = (r==1);
            }
        } catch (SQLException ex) {
            System.err.printf("Hubo un error al agregar: '%s'%n", ex.getMessage());
        }
         return exito;
    }
    
    private List<Usuario> cargarDatos() {
        List<Usuario> lista = new ArrayList<>();
        try {
            File inputFile = new File("C:\\Users\\demil\\Desktop\\votos");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("usuario");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Usuario user = new Usuario(
                            eElement.getElementsByTagName("cedula").item(0).getTextContent(),
                            eElement.getElementsByTagName("nombre").item(0).getTextContent(),
                            eElement.getElementsByTagName("apellido1").item(0).getTextContent(),
                            eElement.getElementsByTagName("apellido2").item(0).getTextContent(),
                            eElement.getElementsByTagName("clave").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("activo").item(0).getTextContent()) 
                    );
                    lista.add(user);
                }
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void xmlToBD() throws InstantiationException, ClassNotFoundException, IllegalAccessException{
        List<Usuario> list = cargarDatos();
        GestorXML d=GestorXML.obtenerInstancia();
        for(int i = 0; i < list.size(); i++){
            d.agregarAlaBD(list.get(i));
        }        
    }
    
    
    private GestorXML() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        bd = GestorBaseDeDatos.obtenerGestorBD(
                GestorBaseDeDatos.GBD.MYSQL_SERVER,
                GestorBaseDeDatos.SERVIDOR_POR_DEFECTO);
    }

    public static GestorXML obtenerInstancia() throws
            InstantiationException,
            ClassNotFoundException,
            IllegalAccessException {
        if (instancia == null) {
            instancia = new GestorXML();
        }
        return instancia;
    }
    
}
