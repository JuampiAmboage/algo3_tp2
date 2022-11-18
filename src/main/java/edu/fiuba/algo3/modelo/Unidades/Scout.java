package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Scout extends Unidad {
    public Scout(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoMinerales = 300;
        costoGas = 150;
        tiempoConstruccion = 9;
        danioTerrestre = 8;
        danioAereo = 14;
        vida = new VidaConEscudo(150,100);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }

    public int obtenerEscudo(){return vida.getEscudoActual();}

}
