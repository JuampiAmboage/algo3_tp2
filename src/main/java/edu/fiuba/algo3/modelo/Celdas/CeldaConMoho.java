package edu.fiuba.algo3.modelo.Celdas;

public class CeldaConMoho extends TipoCelda {
    private int delayExpandir = 2;
    public CeldaConMoho(Celda celda) {
        super(celda);
    }
    @Override
    void pasarTurno() {
        this.delayExpandir--;
        if (this.delayExpandir == 0) {
            this.expandir();
            this.delayExpandir = 2;
        }
    }
    @Override
    boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaConMoho;
    }
    @Override
    void cambiarTipo(TipoCelda t) {
        // No se puede energizar una celda con moho
        // No se puede volver a poner moho en una celda con moho
        if (t instanceof CeldaEnergizada || t instanceof CeldaConMoho) return;
        this.celda.tipo = t;
    }
    public void expandir() {
        for(int i = 0; i < this.celda.celdasAdyacentes.size(); i++) {
            // Contagia de moho a las celdas que no están ocupadas
            if (!this.celda.celdasAdyacentes.get(i).estaOcupada()) {
                this.celda.celdasAdyacentes.get(i).cambiarTipo(new CeldaConMoho(this.celda));
            }
        }
    }



}
