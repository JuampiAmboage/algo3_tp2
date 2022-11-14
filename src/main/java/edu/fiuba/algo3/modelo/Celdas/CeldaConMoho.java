package edu.fiuba.algo3.modelo.Celdas;

public class CeldaConMoho extends TipoCelda{
    public CeldaConMoho(Celda celda) {
        super(celda);
    }

    @Override
    void pasarTurno() {
        this.expandir();
    }

    @Override
    boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaConMoho;
    }

    @Override
    boolean estaOcupada() {
        return this.celda.ocupante != null;
    }

    @Override
    void cambiarTipo(TipoCelda t) {
        this.celda.tipo = t;
    };

    public void expandir() {
        for(int i = 0; i < this.celda.celdasAdyacentes.size(); i++) {
            // Contagia de Moho a las celdas que no están ocupadas
            // todo esto debería ocurrir dentro de dos turnos
            if (!this.celda.celdasAdyacentes.get(i).estaOcupada()) {
                this.celda.celdasAdyacentes.get(i).cambiarTipo(new CeldaConMoho(this.celda));
            }
        }
    }
}
