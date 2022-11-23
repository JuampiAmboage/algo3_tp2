package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

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

    public void instanciacionInicial(Posicion posicionAColocar){
        posicion = posicionAColocar;
        rangoAtaque = new RangoAtaque(4,posicion);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }

    public int obtenerEscudo(){return vida.getEscudoActual();}
}