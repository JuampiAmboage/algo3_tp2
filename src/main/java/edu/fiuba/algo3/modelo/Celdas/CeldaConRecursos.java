package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Raza.Raza;

public abstract class CeldaConRecursos extends Celda {
    protected int cantidadRestanteRecurso;

    public CeldaConRecursos(){
        super();
    }

    public void ocupar(Edificio nuevoEdificioRecolector) {
        if(edificioEnCelda != null)
            edificioEnCelda = nuevoEdificioRecolector;
    }

    public void desocupar(){
        edificioEnCelda = null;
    }

    public abstract void extraerRecurso();

}
