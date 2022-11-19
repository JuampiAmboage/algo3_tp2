package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;

public class CeldaConMoho extends TipoCelda {
    private int delayExpandir = 2;

    private RangoExpansible rango;
    public CeldaConMoho() {
        super();
    }
    public CeldaConMoho(Celda celda) {
        super(celda);
    }

    private void expandir() {
        for(int i = 0; i < this.celda.celdasAdyacentes.size(); i++) {
            // Contagia de moho a las celdas que no están ocupadas
            Celda celdaActual = this.celda.celdasAdyacentes.get(i);
            if (!celdaActual.estaOcupada()) {
                celdaActual.cambiarTipo(new CeldaConMoho(celdaActual));
            }
        }
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
    public void cambiarTipo(TipoCelda t) {
        // No se puede energizar una celda con moho
        // No se puede volver a poner moho en una celda con moho
        if (t instanceof CeldaEnergizada || t instanceof CeldaConMoho) return;
        this.celda.tipo = t;
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreTipo(this);
    }
}
