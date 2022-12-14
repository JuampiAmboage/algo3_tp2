package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class OpcionElegible {
    public String titulo;
    public String pertenceA;
    public String inforomacionSobreOpcion;
    public int cantidadDeOpcionesInternas;
    public ArrayList<String> textoBotones;

    protected Celda[] celdasConExtractor;

    public String obtenerTitulo() { return this.titulo; }
    public String obtenerPertenencia(){ return this.pertenceA; }

    public int obtenerCantidadDeOpcionesInternas() {return this.cantidadDeOpcionesInternas; }
    public String obtenerInformacionSobreOpcion() {
        if (this.inforomacionSobreOpcion != null) { return this.inforomacionSobreOpcion; }
        return null;
    }
    public String obtenerTextoBoton(int index) { return this.textoBotones.get(index); }

    public abstract void gestionarClick(Celda celda, String opcionElejida);

    public void estblecerCeldasConExtractor(Celda[] celdas) {
        this.celdasConExtractor =  celdas;
    }

}
