package model;

import java.util.Date;

public class ControlDisciplinarioThis {
    private int id;
    private int idEstudiante;
    private Date fecha;
    private int idResponsable;
    private int idTipoFalta;
    private int idSancion;
    private int faltasAcumuladas;
    private String observaciones;

    // Constructor vacío
    public ControlDisciplinarioThis() {
    }

    // Constructor con parámetros
    public ControlDisciplinarioThis(int idEstudiante, Date fecha, int idResponsable, 
                              int idTipoFalta, int idSancion, int faltasAcumuladas, 
                              String observaciones) {
        this.idEstudiante = idEstudiante;
        this.fecha = fecha;
        this.idResponsable = idResponsable;
        this.idTipoFalta = idTipoFalta;
        this.idSancion = idSancion;
        this.faltasAcumuladas = faltasAcumuladas;
        this.observaciones = observaciones;
    }

    // Getters y Setters (nombres correctos)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public int getIdTipoFalta() {
        return idTipoFalta;
    }

    public void setIdTipoFalta(int idTipoFalta) {
        this.idTipoFalta = idTipoFalta;
    }

    public int getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(int idSancion) {
        this.idSancion = idSancion;
    }

    public int getFaltasAcumuladas() {
        return faltasAcumuladas;
    }

    public void setFaltasAcumuladas(int faltasAcumuladas) {
        this.faltasAcumuladas = faltasAcumuladas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}