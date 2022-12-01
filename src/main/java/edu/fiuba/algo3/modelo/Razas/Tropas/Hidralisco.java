package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Salud.Vida;

public class Hidralisco extends Tropa {
    public Hidralisco(){
        ataque = new AtacarTierraYAire();
        superficie = "tierra";
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 10;
        danioAereo = 10;
        vida = new Vida(80);
    }
    public void realizarAccionesTurno(){}

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
