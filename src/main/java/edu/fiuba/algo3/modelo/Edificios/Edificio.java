package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.vida.Salud;

public abstract class Edificio extends Racita {
    protected int tiempoDeConstruccion;
    public Edificio() {}
    public Edificio(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }

    public abstract void pasarTurno();
    public abstract boolean estaOperativo();
}
