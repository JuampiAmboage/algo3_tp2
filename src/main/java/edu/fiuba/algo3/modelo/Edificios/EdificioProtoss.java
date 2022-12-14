package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Energizacion.Energizado;
import edu.fiuba.algo3.modelo.Energizacion.EstadoEnergia;
import edu.fiuba.algo3.modelo.Energizacion.NoEnergizado;

public abstract class EdificioProtoss extends Edificio{
    protected EstadoEnergia estadoEnergia;

    public EdificioProtoss(){
        super();
        this.estadoEnergia = new Energizado(this);
    }
    public void realizarAccionesTurno(){estadoEnergia.realizarAccionesTurno();}

    public void accionesTurnoSiEstaEnergizado(){vida.pasarTurno();}

    public void energizar(){
        this.estadoEnergia = new Energizado(this);
    }
    public void desenergizar(){
        this.estadoEnergia = new NoEnergizado();
    }

    public void estaEnergizado(){
        this.estadoEnergia.estaEnergizado();
    }

}
