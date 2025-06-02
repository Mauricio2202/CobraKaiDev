
package model;

import java.time.LocalDate;

public class AdministracionInstructores {
    private LocalDate fechaIngreso;
    private String tipoContrato;
    private String tipoRol;
    private String estado;

    public AdministracionInstructores() {
    }

    public AdministracionInstructores(LocalDate fechaIngreso, String tipoContrato, String tipoRol, String estado) {
        this.fechaIngreso = fechaIngreso;
        this.tipoContrato = tipoContrato;
        this.tipoRol = tipoRol;
        this.estado = estado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
