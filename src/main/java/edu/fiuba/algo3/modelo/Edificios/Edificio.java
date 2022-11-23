package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Razas.Raza;

public abstract class Edificio extends Raza implements Construible{
    protected EstadoConstruccion estado;
    public Edificio() {
        this.estado = new EdificioConstruido(this);
    }
    public Edificio(int tiempoDeConstruccion) {
        this.estado = new EdificioEnConstruccion(this, tiempoDeConstruccion);
    }
    public abstract void pasarTurno();
    public abstract void accionarTurno();
}
