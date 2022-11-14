package edu.fiuba.algo3.modelo.Celdas;

public class CeldaEnergizada extends TipoCelda{
    private int energia;
    public CeldaEnergizada(Celda celda) {
        super(celda);
        energia = 1;
    }

    @Override
    void pasarTurno() {

    }

    @Override
    boolean esMismoTipo(Object objeto) {
        return false;
    }

    @Override
    boolean estaOcupada() {
        return false;
    }

    @Override
    void cambiarTipo(TipoCelda t) {
        if (t instanceof CeldaEnergizada) {
            energia ++;
        } else {
            this.celda.tipo = t;
        }
    }

    public void expandir() {

    }
}
