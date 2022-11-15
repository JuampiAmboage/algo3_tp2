package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Scout extends Unidad {
    public Scout(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoMinerales = 300;
        costoGas = 150;
        tiempo_constuccion = 9;
        danioTerrestre = 8;
        danioAereo = 14;
        rango_ataque = 4;
        vida = new VidaConEscudo(150,100);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
