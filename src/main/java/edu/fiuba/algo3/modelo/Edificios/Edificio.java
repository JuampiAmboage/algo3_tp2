package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Razas.EstadoConstruccion;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Razas.UnidadConstruida;
import edu.fiuba.algo3.modelo.Razas.UnidadEnConstruccion;

public abstract class Edificio extends Unidad implements Construible{
    public Edificio(){super();}
    public Edificio(int tiempoDeConstruccion) {
        if (tiempoDeConstruccion == 0) {
            this.estado = new UnidadConstruida(this);
        } else {
            this.estado = new UnidadEnConstruccion(this);
        }
    }
}
