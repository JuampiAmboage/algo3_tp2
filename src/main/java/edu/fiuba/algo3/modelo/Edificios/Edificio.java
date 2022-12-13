package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Construccion.UnidadConstruida;
import edu.fiuba.algo3.modelo.Construccion.UnidadEnConstruccion;

public abstract class Edificio extends Unidad implements Construible{
    public Edificio(){super();}
    public void construccionInstantanea() {
        this.estado = new UnidadConstruida(this);
    }
}
