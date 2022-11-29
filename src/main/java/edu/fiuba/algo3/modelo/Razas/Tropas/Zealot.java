package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Zealot extends Tropa {
    int bajasGeneradas;
    public Zealot(){
        ataque = new AtacarTierra();
        superficie = "tierra";
        costoEnMinerales = 100;
        costoEnGas = 0;
        tiempoConstruccion = 4;
        danioTerrestre = 8;
        danioAereo = 0;
        vida = new VidaConEscudo(100,60);
        bajasGeneradas = 0;
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }

    public int obtenerEscudo(){return vida.getEscudoActual();}

}
