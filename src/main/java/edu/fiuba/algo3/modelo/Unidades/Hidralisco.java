package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.vida.Vida;

public class Hidralisco extends Unidad {
    public Hidralisco(){
        ataque = new AtacarTierraYAire();
        superficie = "tierra";
        costoMinerales = 75;
        costoGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 10;
        danioAereo = 10;
        vida = new Vida(80);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
