package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Scout extends Tropa {
    public Scout(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoEnMinerales = 300;
        costoEnGas = 150;
        tiempoConstruccion = 9;
        danioTerrestre = 8;
        danioAereo = 14;
        vida = new VidaConEscudo(150,100);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }

    public void realizarAccionesTurno(){}
    public int obtenerEscudo(){return vida.getEscudoActual();}

}
