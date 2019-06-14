package Modelo;

import java.io.Serializable;
import org.json.JSONObject;

public class Reporte implements Serializable {

    int votantesRegistrados;
    int votoEfectuados;
    float porcentanjeVotoEfectuado;

    int abstencionismo;
    float pocerntajeAbstencionismo;
    int votosObtenidosPartido;

    float porcentajeVotosPartido;
    String nombreRepresentante;
    String declaratoria;

    public Reporte(int votantesRegistrados, int votoEfectuados, float porcentanjeVotoEfectuado, int abstencionismo, float pocerntajeAbstencionismo, int votosObtenidosPartido, float porcentajeVotosPartido, String nombreRepresentante, String declaratoria) {
        this.votantesRegistrados = votantesRegistrados;
        this.votoEfectuados = votoEfectuados;
        this.porcentanjeVotoEfectuado = porcentanjeVotoEfectuado;
        this.abstencionismo = abstencionismo;
        this.pocerntajeAbstencionismo = pocerntajeAbstencionismo;
        this.votosObtenidosPartido = votosObtenidosPartido;
        this.porcentajeVotosPartido = porcentajeVotosPartido;
        this.nombreRepresentante = nombreRepresentante;
        this.declaratoria = declaratoria;
    }

    public int getVotantesRegistrados() {
        return votantesRegistrados;
    }

    public void setVotantesRegistrados(int votantesRegistrados) {
        this.votantesRegistrados = votantesRegistrados;
    }

    public int getVotoEfectuados() {
        return votoEfectuados;
    }

    public void setVotoEfectuados(int votoEfectuados) {
        this.votoEfectuados = votoEfectuados;
    }

    public float getPorcentanjeVotoEfectuado() {
        return porcentanjeVotoEfectuado;
    }

    public void setPorcentanjeVotoEfectuado(float porcentanjeVotoEfectuado) {
        this.porcentanjeVotoEfectuado = porcentanjeVotoEfectuado;
    }

    public int getAbstencionismo() {
        return abstencionismo;
    }

    public void setAbstencionismo(int abstencionismo) {
        this.abstencionismo = abstencionismo;
    }

    public float getPocerntajeAbstencionismo() {
        return pocerntajeAbstencionismo;
    }

    public void setPocerntajeAbstencionismo(float pocerntajeAbstencionismo) {
        this.pocerntajeAbstencionismo = pocerntajeAbstencionismo;
    }

    public int getVotosObtenidosPartido() {
        return votosObtenidosPartido;
    }

    public void setVotosObtenidosPartido(int votosObtenidosPartido) {
        this.votosObtenidosPartido = votosObtenidosPartido;
    }

    public float getPorcentajeVotosPartido() {
        return porcentajeVotosPartido;
    }

    public void setPorcentajeVotosPartido(float porcentajeVotosPartido) {
        this.porcentajeVotosPartido = porcentajeVotosPartido;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public String getDeclaratoria() {
        return declaratoria;
    }

    public void setDeclaratoria(String declaratoria) {
        this.declaratoria = declaratoria;
    }

    @Override
    public String toString() {
        return toJSON().toString(9);
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();

        r.put("votantesRegistrados", this.getVotantesRegistrados());
        r.put("votoEfectuados", this.getVotoEfectuados());
        r.put("porcentanjeVotoEfectuado", this.getPorcentanjeVotoEfectuado());

        r.put("abstencionismo", this.getAbstencionismo());
        r.put("pocerntajeAbstencionismo", this.getPocerntajeAbstencionismo());
        r.put("votosObtenidosPartido", this.getVotosObtenidosPartido());

        r.put("porcentajeVotosPartido", this.getPorcentajeVotosPartido());
        r.put("nombreRepresentante", this.getNombreRepresentante());
        r.put("declaratoria", this.getDeclaratoria());
        return r;
    }

}
