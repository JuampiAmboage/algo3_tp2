package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public abstract class OpcionElegible {
    public String titulo;
    public String pertenceA;
    public String rutaImagen;
    public String inforomacionSobreOpcion;
    public String textoBoton;

    protected Celda[] celdasConExtractor;

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
    public String obtenerTextoBoton() {
        if (this.textoBoton != null) { return this.textoBoton; }
        return null;
    }

    public abstract void gestionarClick(Celda celda);

    public void estblecerCeldasConExtractor(Celda[] celdas) {
        this.celdasConExtractor =  celdas;
    }

}
