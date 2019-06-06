
package Modelo;

import java.io.Serializable;
import java.sql.Date;



public class Votacion implements Serializable{
    
    private int id;
    private Date fechaInicio;
    private Date fechaApertura;
    private Date fechaCierre;
    private Date fechaFinal;
    private int estado;

    public Votacion(int id, Date fechaInicio, Date fechaApertura, Date fechaCierre, Date fechaFinal, int estado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
    }

    public Votacion() {
        this(0,null,null,null,null,0);
    }

    @Override
    public String toString() {
        return "Votacion{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", fechaFinal=" + fechaFinal + ", estado=" + estado + '}';
    }

    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    public Date getFechaInicio() {
        return fechaInicio;
    }

    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    
    public Date getFechaFinal() {
        return fechaFinal;
    }

    
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    
    public int getEstado() {
        return estado;
    }

    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
