package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.vida.Vida;

public class Mutalisco extends Tropa {
    public Mutalisco(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 9;
        danioAereo = 9;
        vida = new Vida(80);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
