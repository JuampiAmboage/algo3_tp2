package edu.fiuba.algo3.modelo.Celdas;

public class CeldaEnergizada extends TipoCelda{
    private int energia = 0;
    public CeldaEnergizada(Celda celda) {
        super(celda);
        this.energia++;
    }
    @Override
    void pasarTurno() {}
    @Override
    boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaEnergizada;
    }

    @Override
    void cambiarTipo(TipoCelda t) {
        if (t instanceof CeldaEnergizada) {
            this.energia++;
        } else if (t instanceof CeldaLibre){
            this.energia--;
        } else {
            this.celda.tipo = t;
        }
        // Si la celda se queda sin energía
        if (this.energia <= 0) {
            this.celda.tipo = new CeldaLibre(this.celda);
        }
    }
}
