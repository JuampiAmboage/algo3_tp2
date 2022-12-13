package edu.fiuba.algo3.modelo.Opciones;

public abstract class OpcionElegible {
    public String titulo;
    public String pertenceA;
    public String rutaImagen;
    public String inforomacionSobreOpcion;
    public String textoBoton;

    public String obtenerTitulo() { return this.titulo; }
    public String obtenerPertenencia(){ return this.pertenceA; }
    public String obtenerImagen() {
        if (this.rutaImagen != null) { return this.rutaImagen; }
        return null;
    }
    public String obtenerInformacionSobreOpcion() {
        if (this.inforomacionSobreOpcion != null) { return this.inforomacionSobreOpcion; }
        return null;
    }
    public String obtenerBoton() {
        if (this.textoBoton != null) { return this.textoBoton; }
        return null;
    }

    //public void accionar() {}
    //public abstract void gestionarAccion();
}
