package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Zerling extends Tropa implements TropaTerrestre
{
    public Zerling(){
        ataque = new AtacarTierra();
        costoEnMinerales = 25;
        costoEnGas = 0;
        tiempoConstruccion = 2;
        danioTerrestre = 4;
        danioAereo = 0;
        suministro = 1;
        vida = new Vida(35);
        edificioNecesario = new ReservaDeReproduccion();
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        comunidad.aniadirSuministro(suministro);
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
