package ejemplo;

import ejemplo.entidades.ListaUsuarios;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

public class EjemploUsuarios {

    public static void main(String[] args) {
        String nombreArchivo = "../usuarios.xml";
        try {
            ListaUsuarios usuarios = ListaUsuarios.deserializar(new FileInputStream(nombreArchivo));
            System.out.println(usuarios);
        } catch (FileNotFoundException | JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

}
