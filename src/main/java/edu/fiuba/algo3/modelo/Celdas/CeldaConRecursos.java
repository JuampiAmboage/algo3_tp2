package edu.fiuba.algo3.modelo.Celdas;

public class CeldaConRecursos extends TipoCelda {
    private int cantidadRestanteRecurso; // Acá podría tener objeto del tipo Recurso

    public CeldaConRecursos(Celda celda) {
        super(celda);
    }

    @Override
    void pasarTurno() {

    }

    @Override
    boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaConRecursos;
    }

    @Override
    boolean estaOcupada() {
        return true;
    }

    @Override
    void cambiarTipo(TipoCelda t) {
        this.celda.tipo = t;
    }

}
