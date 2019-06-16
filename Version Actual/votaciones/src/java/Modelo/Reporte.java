package Modelo;
//  Reporte.java
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña

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

    int votacion_id;
    String partido_siglas;
    String cedula_candidato;
    int votos_obtenidos;

    public Reporte(int c, float cc, String p, String n) {
        votos_obtenidos = c;
        porcentanjeVotoEfectuado = cc;
        partido_siglas = p;
        nombreRepresentante = n;
    }

    public Reporte(float x, int v) {
        abstencionismo = v;
        pocerntajeAbstencionismo = x;

    }

    public Reporte(int ve, float por) {
        this.votoEfectuados = ve;
        this.porcentanjeVotoEfectuado = por;
    }

    public Reporte(int votacion_id, String partido_siglas, String cedula_candidato, int votos_obtenidos) {
        this.votacion_id = votacion_id;
        this.partido_siglas = partido_siglas;
        this.cedula_candidato = cedula_candidato;
        this.votos_obtenidos = votos_obtenidos;
    }

    public Reporte(int vr) {
        this.votantesRegistrados = vr;
    }

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
        return toJSON().toString(13);
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

        r.put("votacion_id", this.getVotacion_id());
        r.put("partido_siglas", this.getPartido_siglas());
        r.put("cedula_candidato", this.getCedula_candidato());
        r.put("votos_obtenidos", this.getVotos_obtenidos());

        return r;
    }

    public int getVotacion_id() {
        return votacion_id;
    }

    public void setVotacion_id(int votacion_id) {
        this.votacion_id = votacion_id;
    }

    public String getPartido_siglas() {
        return partido_siglas;
    }

    public void setPartido_siglas(String partido_siglas) {
        this.partido_siglas = partido_siglas;
    }

    public String getCedula_candidato() {
        return cedula_candidato;
    }

    public void setCedula_candidato(String cedula_candidato) {
        this.cedula_candidato = cedula_candidato;
    }

    public int getVotos_obtenidos() {
        return votos_obtenidos;
    }

    public void setVotos_obtenidos(int votos_obtenidos) {
        this.votos_obtenidos = votos_obtenidos;
    }

}
