package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Salud.Vida;

public class Guardian extends Tropa{
    public Guardian(){
        ataque = new AtacarTierra();
        superficie = "aire";
        costoEnMinerales = 50;
        costoEnGas = 100;
        tiempoConstruccion = 4;
        danioTerrestre = 25;
        danioAereo = 0;
        vida = new Vida(100);
    }
    public void realizarAccionesTurno(){}


    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
