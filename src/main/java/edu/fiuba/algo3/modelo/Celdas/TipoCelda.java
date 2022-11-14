package edu.fiuba.algo3.modelo.Celdas;

public abstract class TipoCelda {
    protected Celda celda;
    public TipoCelda(Celda celda) {
        this.celda = celda;
    }

    abstract void pasarTurno();

    abstract boolean esMismoTipo(Object objeto);

    abstract void cambiarTipo(TipoCelda t);
}
