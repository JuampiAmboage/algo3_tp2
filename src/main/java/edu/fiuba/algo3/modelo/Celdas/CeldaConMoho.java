package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;

public class CeldaConMoho extends TipoCelda {
    private int delayExpandir = 2;
    private final String RUTA_SPRITE = "celdas/zerg/celdaConMoho.png";

    public CeldaConMoho() {
        super();
        this.sprite = this.RUTA_SPRITE;
    }
    public CeldaConMoho(Celda celda) {
        super(celda);
        this.sprite = this.RUTA_SPRITE;
    }

    private void expandir() {
        RangoExpansible rango = new RangoExpansible(this.celda.posicion, 1);
        rango.expandir(new CeldaConMoho());
    }

    @Override
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    @Override
    public void pasarTurno() {
        this.delayExpandir--;
        if (this.delayExpandir == 0) {
            this.expandir();
            this.delayExpandir = 2;
        }
    }
    @Override
    public boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaConMoho;
    }
    @Override
    protected void cambiarTipoA(CeldaLibre nuevoTipo) {}
    @Override
    protected void cambiarTipoA(CeldaEnergizada nuevoTipo) {}
    @Override
    protected void cambiarTipoA(CeldaConMoho nuevoTipo) {}

    @Override
    public void cambiarTipoDe(Celda c) {
        CeldaConMoho tipo = new CeldaConMoho(c);
        c.tipo.cambiarTipoA(tipo);
    }

    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreTipo(this);
    }
}
