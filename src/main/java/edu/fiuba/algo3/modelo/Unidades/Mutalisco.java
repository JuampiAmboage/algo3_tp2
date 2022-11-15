package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.vida.Vida;

public class Mutalisco extends Unidad {
    public Mutalisco(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoMinerales = 75;
        costoGas = 25;
        tiempo_constuccion = 4;
        danioTerrestre = 9;
        danioAereo = 9;
        rango_ataque = 4;
        vida = new Vida(80);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
