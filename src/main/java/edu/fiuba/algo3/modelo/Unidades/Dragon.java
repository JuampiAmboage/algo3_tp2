package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Dragon extends Tropa {

    public Dragon() {
        ataque = new AtacarTierraYAire();
        superficie = "tierra";
        costoEnMinerales = 125;
        costoEnGas = 50;
        tiempoConstruccion = 6;
        danioTerrestre = 20;
        danioAereo = 20;
        vida = new VidaConEscudo(100,80);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }

    public int obtenerEscudo(){return vida.getEscudoActual();}
}
