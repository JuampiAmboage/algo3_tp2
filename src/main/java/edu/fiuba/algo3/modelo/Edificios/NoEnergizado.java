package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizado;

public class NoEnergizado implements EstadoEnergia{

    public void NoEnergizado(){}

    public void realizarAccionesTurno(){
        throw new EdificioNoEnergizado();
    }

    public void estaEnergizado(){
        throw new EdificioNoEnergizado();
    }
}
