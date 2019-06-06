
package Modelo;

import java.io.Serializable;


public class VotacionUsuario implements Serializable{
    
    private Votacion votId;
    private Usuario usuCedula;
    private int votoCompletado;

    public VotacionUsuario(Votacion votId, Usuario usuCedula, int votoCompletado) {
        this.votId = votId;
        this.usuCedula = usuCedula;
        this.votoCompletado = votoCompletado;
    }

    public VotacionUsuario() {
        this(null,null,0);
    }

    
    public Votacion getVotId() {
        return votId;
    }

    
    public void setVotId(Votacion votId) {
        this.votId = votId;
    }

   
    public Usuario getUsuCedula() {
        return usuCedula;
    }

    
    public void setUsuCedula(Usuario usuCedula) {
        this.usuCedula = usuCedula;
    }

    
    public int getVotoCompletado() {
        return votoCompletado;
    }

    
    public void setVotoCompletado(int votoCompletado) {
        this.votoCompletado = votoCompletado;
    }
    
    
    
}
