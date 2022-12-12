package edu.fiuba.algo3.modelo.Energizacion;

import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Energizacion.EstadoEnergia;

public class Energizado implements EstadoEnergia {
    private EdificioProtoss edificioProtoss;

    public Energizado(EdificioProtoss edificioProtoss){ this.edificioProtoss = edificioProtoss;}

    public void realizarAccionesTurno(){
        edificioProtoss.accionesTurnoSiEstaEnergizado();
    }

    public void estaEnergizado(){}
}
