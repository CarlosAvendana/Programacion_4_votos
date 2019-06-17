package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lista-usuarios")
public class ListaUsuarios implements Serializable {

    public ListaUsuarios(List<Usuario1> usuarios) {
        this.usuarios = usuarios;
    }

    public ListaUsuarios() {
        usuarios = new ArrayList<>();
    }

    public List<Usuario1> obtenerLista() {
        return Collections.unmodifiableList(usuarios);
    }

    public static ListaUsuarios deserializar(InputStream entradaXML) throws JAXBException {
        ListaUsuarios r = null;
        try {
            JAXBContext ctx = JAXBContext.newInstance(ListaUsuarios.class);
            Unmarshaller mrs = ctx.createUnmarshaller();
            r = (ListaUsuarios) mrs.unmarshal(entradaXML);
        } catch (JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw ex;
        }
        return r;
    }

    @Override
    public String toString() {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        return g.toJson(this);
    }

    @XmlElement(name = "usuario")
    private final List<Usuario1> usuarios;
}
