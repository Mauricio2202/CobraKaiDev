
package model;

import java.time.LocalDate;

/**
 *
 * @author 52551
 */
public class EvaluacionRango {
    private String nombreEstudiante;
    private LocalDate fechaEvaluacion;
    private String rangoAplica;
    private String rangoActual;
    private String observaciones;
    private String evaluador;

    public EvaluacionRango() {
    }

    public EvaluacionRango(String nombreEstudiante, LocalDate fechaEvaluacion, String rangoAplica, String rangoActual, String observaciones, String evaluador) {
        this.nombreEstudiante = nombreEstudiante;
        this.fechaEvaluacion = fechaEvaluacion;
        this.rangoAplica = rangoAplica;
        this.rangoActual = rangoActual;
        this.observaciones = observaciones;
        this.evaluador = evaluador;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getRangoAplica() {
        return rangoAplica;
    }

    public void setRangoAplica(String rangoAplica) {
        this.rangoAplica = rangoAplica;
    }

    public String getRangoActual() {
        return rangoActual;
    }

    public void setRangoActual(String rangoActual) {
        this.rangoActual = rangoActual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }
    
    
}
