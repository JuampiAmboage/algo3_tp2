package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Raza.Raza;

public abstract class CeldaConRecursos implements Celda {
    protected int cantidadRestanteRecurso;
    protected Edificio edificioRecolector;

    public CeldaConRecursos(){
        edificioRecolector = null;
    }
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

    public boolean esCelda(){
        return true;
    }

    public abstract int extraerRecurso();

}
