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
    // TODO: Hacer este metodo abstracto y que cada opcion ponga su funcionalidad ahi.
    public void gestionarClick() {
        System.out.println("funciona");
    }
}
