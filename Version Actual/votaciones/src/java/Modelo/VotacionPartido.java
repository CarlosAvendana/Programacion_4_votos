package Modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import org.json.JSONObject;

public class VotacionPartido implements Serializable {

    private Votacion votId;
    private Partido partSiglas;
    private Usuario cedCandidato;
    private String fotoCandidato;
    private int votosObtenidos;

    public VotacionPartido(Votacion votId, Partido partSiglas, Usuario cedCandidato,  int votosObtenidos) {
        this.votId = votId;
        this.partSiglas = partSiglas;
        this.cedCandidato = cedCandidato;
        this.votosObtenidos = votosObtenidos;
    }

    public VotacionPartido() {
        this(null, null, null, 0);
    }

//    @Override
//    public String toString() {
//        return "VotacionPartido{" + "votId=" + votId + ", partSiglas=" + partSiglas + ", cedCandidato=" + cedCandidato + ", fotoCandidato=" + fotoCandidato + ", votosObtenidos=" + votosObtenidos + '}';
//    }
    public Votacion getVotId() {
        return votId;
    }

    @XmlElement
    public void setVotId(Votacion votId) {
        this.votId = votId;
    }

    public Partido getPartSiglas() {
        return partSiglas;
    }

    @XmlElement
    public void setPartSiglas(Partido partSiglas) {
        this.partSiglas = partSiglas;
    }

    public Usuario getCedCandidato() {
        return cedCandidato;
    }

    @XmlElement
    public void setCedCandidato(Usuario cedCandidato) {
        this.cedCandidato = cedCandidato;
    }

    public String getFotoCandidato() {
        return fotoCandidato;
    }

    @XmlElement
    public void setFotoCandidato(String fotoCandidato) {
        this.fotoCandidato = fotoCandidato;
    }

    public int getVotosObtenidos() {
        return votosObtenidos;
    }

    @XmlElement
    public void setVotosObtenidos(int votosObtenidos) {
        this.votosObtenidos = votosObtenidos;
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id_votacion", getVotId().getId());
        r.put("partido_siglas", getPartSiglas().getSiglas());
        r.put("cedula_candidato", getCedCandidato().getCedula());
        r.put("votos_obtenidos", getVotosObtenidos());
        return r;
    }

    @Override
    public String toString() {
        return toJSON().toString(7);
    }
}
