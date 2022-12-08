package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Devorador extends TropaAerea{
    public Devorador(){
        super();
        ataque = new AtacarAire();
        costoEnMinerales = 150;
        costoEnGas = 50;
        tiempoConstruccion = 4;
        danioTerrestre = 0;
        danioAereo = 15;
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        vida = new Vida(200);
    }
    public void realizarAccionesTurno(){}


    public void instanciacionInicial(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,5,posicion);

    }
    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
