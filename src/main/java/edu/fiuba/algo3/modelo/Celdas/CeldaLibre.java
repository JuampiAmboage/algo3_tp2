package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;

public class CeldaLibre extends TipoCelda {
    public CeldaLibre() {super();}
    public CeldaLibre(Celda celda) {
        super(celda);
    }

    @Override
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    @Override
    public void pasarTurno() {}
    @Override
    public boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaLibre;
    }
    @Override
    protected void cambiarTipo(TipoCelda t) {
        this.celda.tipo = t;
    }
    @Override
    public void cambiarTipoDe(Celda c) {
        CeldaLibre tipo = new CeldaLibre(c);
        c.tipo.cambiarTipo(tipo);
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreTipo(this);
    }
}
