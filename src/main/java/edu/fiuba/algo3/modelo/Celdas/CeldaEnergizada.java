package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;

public class CeldaEnergizada extends TipoCelda{
    private int energia = 0;
    public CeldaEnergizada(){
        super();
        this.energia++;
    }
    public CeldaEnergizada(Celda celda) {
        super(celda);
        this.energia++;
    }

    @Override
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    @Override
    public void pasarTurno() {}
    @Override
    public boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaEnergizada;
    }
    @Override
    public void cambiarTipo(TipoCelda t) {
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
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreTipo(this);
    }
}
