package model;

import java.time.LocalDate;

public class RegistroUsuario {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private int idioma;
    private int paisOrigen;
    private String estado;
    private String municipio;
    private String codigoPostal;
    private String colonia;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String correo;
    private String telefonoLocal;
    private String telefonoMovil;
    private String parentesco;
    private int autorizacionFisica;
    private byte[] foto;

    public int getId() {
        return id; 
    }
    public void setId(int id) { 
        this.id = id;
    }
    public String getNombre() { 
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
    public String getApellidoPaterno() { 
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) { 
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() { 
        return apellidoMaterno; 
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno; 
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento; 
    }
    public int getIdioma() { 
        return idioma; 
    }
    public void setIdioma(int idioma) {
        this.idioma = idioma; 
    }
    public int getPaisOrigen() {
        return paisOrigen;
    }
    public void setPaisOrigen(int paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    public String getEstado() {
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getCodigoPostal() { 
        return codigoPostal; 
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal; 
    }
    public String getColonia() {
        return colonia; 
    }
    public void setColonia(String colonia) {
        this.colonia = colonia; 
    }
    public String getCalle() { 
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle; 
    }
    public String getNumeroExterior() { 
        return numeroExterior; 
    }
    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior; 
    }
    public String getNumeroInterior() {
        return numeroInterior; 
    }
    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior; 
    }
    public String getCorreo() {
        return correo; 
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefonoLocal() {
        return telefonoLocal; 
    }
    public void setTelefonoLocal(String telefonoLocal) {
        this.telefonoLocal = telefonoLocal;
    }
    public String getTelefonoMovil() {
        return telefonoMovil; 
    }
    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
    public String getParentesco() { 
        return parentesco; 
    }
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    public int getAutorizacionFisica() {
        return autorizacionFisica;
    }
    public void setAutorizacionFisica(int autorizacionFisica) { 
        this.autorizacionFisica = autorizacionFisica;
    }
    public byte[] getFoto() { 
        return foto; 
    }
    public void setFoto(byte[] foto) {
        this.foto = foto; 
    }
}