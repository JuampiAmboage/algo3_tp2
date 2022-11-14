package edu.fiuba.algo3.modelo.Celdas;

public class CeldaLibre extends TipoCelda {
    public CeldaLibre(Celda celda) {
        super(celda);
    }

    @Override
    void pasarTurno() {}
    @Override
    boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaLibre;
    }

    @Override
    void cambiarTipo(TipoCelda t) {
        this.celda.tipo = t;
    }

}
