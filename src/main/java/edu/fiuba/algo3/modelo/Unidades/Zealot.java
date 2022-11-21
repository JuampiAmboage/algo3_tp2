package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Zealot extends Tropa {
    int bajasGeneradas;
    public Zealot(){
        ataque = new AtacarTierra();
        superficie = "tierra";
        costoMinerales = 100;
        costoGas = 0;
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
