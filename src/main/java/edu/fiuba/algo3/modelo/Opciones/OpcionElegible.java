package edu.fiuba.algo3.modelo.Opciones;

public abstract class OpcionElegible {
    public String titulo;
    public String pertenceA;
    public String rutaImagen;
    public String infromacionSobreOpcion;
    public String[] botones;

    public String obtenerTitulo() { return this.titulo; }
    public String obtenerPertenencia(){ return this.pertenceA; }
    public String obtenerImagen() {
        if (this.rutaImagen != null) { return this.rutaImagen; }
        return null;
    }
    public String obtenerInformacionSobreopcion() {
        if (this.obtenerInformacionSobreopcion() != null) { return this.infromacionSobreOpcion; }
        return null;
    }
    public String[] obtenerBotones() {
        if (this.botones != null) { return this.botones; }
        return null;
    }
}
