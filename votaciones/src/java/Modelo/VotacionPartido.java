/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author demil
 */
public class VotacionPartido implements Serializable{
    
    private Votacion votId;
    private Partido partSiglas;
    private Usuario cedCandidato;
    private String fotoCandidato;
    private int votosObtenidos;

    public VotacionPartido(Votacion votId, Partido partSiglas, Usuario cedCandidato, String fotoCandidato, int votosObtenidos) {
        this.votId = votId;
        this.partSiglas = partSiglas;
        this.cedCandidato = cedCandidato;
        this.fotoCandidato = fotoCandidato;
        this.votosObtenidos = votosObtenidos;
    }

    public VotacionPartido() {
        this(null,null,null,null,0);
    }

    @Override
    public String toString() {
        return "VotacionPartido{" + "votId=" + votId + ", partSiglas=" + partSiglas + ", cedCandidato=" + cedCandidato + ", fotoCandidato=" + fotoCandidato + ", votosObtenidos=" + votosObtenidos + '}';
    }

    
    
    public Votacion getVotId() {
        return votId;
    }

    
    public void setVotId(Votacion votId) {
        this.votId = votId;
    }

    
    public Partido getPartSiglas() {
        return partSiglas;
    }

    
    public void setPartSiglas(Partido partSiglas) {
        this.partSiglas = partSiglas;
    }

    
    public Usuario getCedCandidato() {
        return cedCandidato;
    }

    
    public void setCedCandidato(Usuario cedCandidato) {
        this.cedCandidato = cedCandidato;
    }

    
    public String getFotoCandidato() {
        return fotoCandidato;
    }

    
    public void setFotoCandidato(String fotoCandidato) {
        this.fotoCandidato = fotoCandidato;
    }

    
    public int getVotosObtenidos() {
        return votosObtenidos;
    }

    
    public void setVotosObtenidos(int votosObtenidos) {
        this.votosObtenidos = votosObtenidos;
    }
    
    
    
    
}
