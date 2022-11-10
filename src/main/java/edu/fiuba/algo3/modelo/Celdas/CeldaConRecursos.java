package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

public abstract class CeldaConRecursos implements Celda {
    protected int cantidadRecursoRestante;
    protected Edificio edificioRecolector;

    public void pasarTurno(){
        edificioRecolector.pasarTurno();
    }

    public void ocupar(Edificio nuevoEdificioRecolector) {
        if(edificioRecolector != null)
            edificioRecolector = nuevoEdificioRecolector;

    }

    public void desocupar(){
        edificioRecolector = null;
    }

    public abstract int extraerRecurso();

}
