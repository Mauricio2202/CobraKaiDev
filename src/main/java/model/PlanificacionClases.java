
package model;

import java.time.LocalDate;

public class PlanificacionClases {
    private String nombreClase;
    private String instructorPresente;
    private String rolInstructor;
    private String nivelTecnico;
    private String modalidad;
    private LocalDate fechaClase;
    
    private boolean asistenciaConfirmada;
    
    private String estado;
    private int cantidadMaxPersonas;

    private String reporteActividades;

    public PlanificacionClases() {
    }

    public PlanificacionClases(String nombreClase, String instructorPresente, String rolInstructor, String nivelTecnico, String modalidad, LocalDate fechaClase, boolean asistenciaConfirmada, String estado, int cantidadMaxPersonas, String reporteActividades) {
        this.nombreClase = nombreClase;
        this.instructorPresente = instructorPresente;
        this.rolInstructor = rolInstructor;
        this.nivelTecnico = nivelTecnico;
        this.modalidad = modalidad;
        this.fechaClase = fechaClase;
        this.asistenciaConfirmada = asistenciaConfirmada;
        this.estado = estado;
        this.cantidadMaxPersonas = cantidadMaxPersonas;
        this.reporteActividades = reporteActividades;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getInstructorPresente() {
        return instructorPresente;
    }

    public void setInstructorPresente(String instructorPresente) {
        this.instructorPresente = instructorPresente;
    }

    public String getRolInstructor() {
        return rolInstructor;
    }

    public void setRolInstructor(String rolInstructor) {
        this.rolInstructor = rolInstructor;
    }

    public String getNivelTecnico() {
        return nivelTecnico;
    }

    public void setNivelTecnico(String nivelTecnico) {
        this.nivelTecnico = nivelTecnico;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public LocalDate getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(LocalDate fechaClase) {
        this.fechaClase = fechaClase;
    }

    public boolean isAsistenciaConfirmada() {
        return asistenciaConfirmada;
    }

    public void setAsistenciaConfirmada(boolean asistenciaConfirmada) {
        this.asistenciaConfirmada = asistenciaConfirmada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadMaxPersonas() {
        return cantidadMaxPersonas;
    }

    public void setCantidadMaxPersonas(int cantidadMaxPersonas) {
        this.cantidadMaxPersonas = cantidadMaxPersonas;
    }

    public String getReporteActividades() {
        return reporteActividades;
    }

    public void setReporteActividades(String reporteActividades) {
        this.reporteActividades = reporteActividades;
    }
    
    
}
