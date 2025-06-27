
package model;

import java.awt.List;

/**
 *
 * @author 52551
 */
public class Torneos {
    private String nombreEstudiante;
    private float peso;
    private int edad;
    private String cinturon;
    private boolean estado;
    private String categoria;
    private String eventoSeleccionado;
    private List listaTorneos;    

    public Torneos() {
    }

    public Torneos(String nombreEstudiante, float peso, int edad, String cinturon, boolean estado, String categoria, String eventoSeleccionado, List listaTorneos) {
        this.nombreEstudiante = nombreEstudiante;
        this.peso = peso;
        this.edad = edad;
        this.cinturon = cinturon;
        this.estado = estado;
        this.categoria = categoria;
        this.eventoSeleccionado = eventoSeleccionado;
        this.listaTorneos = listaTorneos;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCinturon() {
        return cinturon;
    }

    public void setCinturon(String cinturon) {
        this.cinturon = cinturon;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEventoSeleccionado() {
        return eventoSeleccionado;
    }

    public void setEventoSeleccionado(String eventoSeleccionado) {
        this.eventoSeleccionado = eventoSeleccionado;
    }

    public List getListaTorneos() {
        return listaTorneos;
    }

    public void setListaTorneos(List listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
    
    
}
