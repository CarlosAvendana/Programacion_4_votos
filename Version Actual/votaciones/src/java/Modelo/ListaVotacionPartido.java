package Modelo;

import Gestores.GestorVotacionPartido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONArray;
import org.json.JSONObject;

@XmlRootElement(name = "lista-votacionPartido")
public class ListaVotacionPartido implements Serializable {

    @XmlElement(name = "votacionPartidos")
    private final List<VotacionPartido> votacionPartidos;

    public ListaVotacionPartido(List<VotacionPartido> votacionPartidos) {
        this.votacionPartidos = votacionPartidos;
    }

    public ListaVotacionPartido() {
        votacionPartidos = new ArrayList<>();
    }

    public void agregar(GestorVotacionPartido gvp) {
        votacionPartidos.forEach((p) -> {
            gvp.agregar(p);
        });
    }

    @Override
    public String toString() {
        return toJSON().toString(7);
    }

    public JSONObject toJSON() {
        JSONArray a = new JSONArray();
        votacionPartidos.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-votacionPartido", a);
        return r;
    }

}
