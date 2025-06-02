
package model;

import java.time.LocalDate;

public class EvolucionEstudiante {
    private LocalDate fechaIngreso;
    private String rangoActual;
    private String estado;

    public EvolucionEstudiante() {
    }

    public EvolucionEstudiante(LocalDate fechaIngreso, String rangoActual, String estado) {
        this.fechaIngreso = fechaIngreso;
        this.rangoActual = rangoActual;
        this.estado = estado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getRangoActual() {
        return rangoActual;
    }

    public void setRangoActual(String rangoActual) {
        this.rangoActual = rangoActual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
