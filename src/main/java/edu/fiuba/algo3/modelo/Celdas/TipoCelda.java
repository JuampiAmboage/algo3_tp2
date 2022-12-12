package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;

import java.util.ArrayList;

public abstract class TipoCelda {
    protected Celda celda;

    public final String sprite = "/sprites/celdas/";
    public TipoCelda() {}
    public TipoCelda(Celda celda) {
        this.celda = celda;
    }

    public abstract void setCelda(Celda celda);
    public abstract void pasarTurno();
    public abstract boolean esMismoTipo(Object objeto);
    //protected abstract void cambiarTipo(TipoCelda t);
    protected abstract void cambiarTipoA(CeldaLibre t);
    protected abstract void cambiarTipoA(CeldaConMoho t);
    protected abstract void cambiarTipoA(CeldaEnergizada t);
    public abstract void cambiarTipoDe(Celda c);
    public abstract void quiereConstruir(Construible construible);

    public abstract String obtenerSprite();

    public abstract ArrayList<String> obtenerOpciones();
}
