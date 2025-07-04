package model;

public class Archivo {
    public enum TipoArchivo { Certificados, Eventos, Otros }

    private int id;
    private String nombreArchivo;
    private String rutaArchivo;
    private TipoArchivo tipoArchivo;

    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }
    public String getNombreArchivo() { 
        return nombreArchivo; 
    }
    public void setNombreArchivo(String nombreArchivo) { 
        this.nombreArchivo = nombreArchivo; 
    }
    public String getRutaArchivo() { 
        return rutaArchivo;
    }
    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    public TipoArchivo getTipoArchivo() {
        return tipoArchivo; 
    }
    public void setTipoArchivo(TipoArchivo tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }
}