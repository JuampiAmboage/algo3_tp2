package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class OpcionElegible {
    public String titulo;
    public String pertenceA;
    public ArrayList<String> textoBotones = new ArrayList<>();

    protected Celda[] celdasConExtractor;

    public String obtenerTitulo() { return this.titulo; }
    public String obtenerPertenencia(){ return this.pertenceA; }

    public String obtenerTextoBoton(int index) { return this.textoBotones.get(index); }

    public abstract void gestionarClick(Celda celda, String opcionElejida);

    public void estblecerCeldasConExtractor(Celda[] celdas) {
        this.celdasConExtractor =  celdas;
    }

}
