package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizado;

public class Energizado implements EstadoEnergia{
    private EdificioProtoss edificioProtoss;

    public Energizado(EdificioProtoss edificioProtoss){ this.edificioProtoss = edificioProtoss;}

    public void realizarAccionesTurno(){
        edificioProtoss.accionesTurnoSiEstaEnergizado();
    }

    public void estaEnergizado(){}
}
