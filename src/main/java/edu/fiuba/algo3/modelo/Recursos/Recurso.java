package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;

import java.util.ArrayList;

public abstract class Recurso {
    protected int cantidad;
    protected String rutaSprite = "/sprites/recursos/";
    protected ArrayList<OpcionElegible> opciones = new ArrayList<OpcionElegible>();

    public Recurso() {}
    public abstract int extraer(int cantidad);
    public abstract void quiereConstruir(Construible construible);

    public abstract ArrayList<OpcionElegible> obtenerOpciones();

    public abstract String obtenerSprite();
}
