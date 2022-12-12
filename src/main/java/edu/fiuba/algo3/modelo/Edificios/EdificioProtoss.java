package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Partida.Mapa;

public abstract class EdificioProtoss extends Edificio{
    protected EstadoEnergia estadoEnergia;

    protected String spriteDesenergizado;

    public EdificioProtoss(){
        this.estadoEnergia = new Energizado(this);
    }

    public void realizarAccionesTurno(){estadoEnergia.realizarAccionesTurno();}

    public void accionesTurnoSiEstaEnergizado(){vida.pasarTurno();}

    public void energizar(){
        this.estadoEnergia = new Energizado(this);
        Mapa.getInstance().obtenerCelda(this.posicion).aplicarSpriteOcupante(sprite);//sprite original
    }
    public void desenergizar(){
        this.estadoEnergia = new NoEnergizado();
        Mapa.getInstance().obtenerCelda(this.posicion).aplicarSpriteOcupante(spriteDesenergizado);
    }

    public void estaEnergizado(){
        this.estadoEnergia.estaEnergizado();
    }

}