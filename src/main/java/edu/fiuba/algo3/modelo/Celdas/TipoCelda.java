package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Comunidad.Unidad;

public abstract class TipoCelda {
    protected Celda celda;

    public TipoCelda(Celda celda) {
        this.celda = celda;
    }

    abstract void pasarTurno();

    abstract boolean esMismoTipo(Object objeto);

    abstract boolean estaOcupada();
}
