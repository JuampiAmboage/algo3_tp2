package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public abstract class Recurso {
    Posicion posicion;
    protected int cantidad;
    protected String rutaSprite = "/sprites/recursos/";
    protected ArrayList<OpcionElegible> opciones = new ArrayList<OpcionElegible>();

    public Recurso() {}

    public void posicionarRecurso(Posicion posicionCelda){
        this.posicion = posicionCelda;
    }
    public abstract int extraer(int cantidad);
    public abstract void quiereConstruir(Construible construible);

    public double obtenerDistanciaA(int coordenadaX, int coordenadaY){
        return posicion.obtenerDistanciaA(coordenadaX,coordenadaY);
    }

    public abstract ArrayList<OpcionElegible> obtenerOpciones();

    public abstract String obtenerSprite();
}
