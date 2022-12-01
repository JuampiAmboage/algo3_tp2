package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Zerling extends Tropa
{
    public Zerling(){
        ataque = new AtacarTierra();
        superficie = "tierra";
        costoEnMinerales = 25;
        costoEnGas = 0;
        tiempoConstruccion = 2;
        danioTerrestre = 4;
        danioAereo = 0;
        vida = new Vida(35);
    }

    public void instanciacionInicial(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(1,posicion);

    }
    public void realizarAccionesTurno(){}
    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
