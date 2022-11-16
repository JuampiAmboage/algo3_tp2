package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;

public abstract class TipoCelda {
    protected Celda celda;
    public TipoCelda() {}
    public TipoCelda(Celda celda) {
        this.celda = celda;
    }

    public abstract void setCelda(Celda celda);
    public abstract void pasarTurno();
    public abstract boolean esMismoTipo(Object objeto);
    public abstract void cambiarTipo(TipoCelda t);
    public abstract void quiereConstruir(Construible construible);
}
