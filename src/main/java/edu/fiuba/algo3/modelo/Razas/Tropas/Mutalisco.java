package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.EvolucionIncompatibleConTropaEvolucionableActual;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Evolucionador;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Mutalisco extends Tropa implements TropaAerea, UnidadEvolucionable {
    Evolucionador evolucionador;
    public Mutalisco(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 9;
        danioAereo = 9;
        suministro = 4;
        vida = new Vida(80);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirSuministro(suministro);

    }

    public void mutar(Tropa unidadPostMutacion){
        if(unidadPostMutacion.getClass().equals(Guardian.class) || unidadPostMutacion.getClass().equals(Devorador.class)) {
            ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
            comunidadZerg.agregarUnidad(unidadPostMutacion);
            comunidadZerg.quitarUnidad(this);
        }
    }

    public void evolucionarAEdificio(Edificio edificioNuevo){
        throw new EvolucionIncompatibleConTropaEvolucionableActual();
    }

    public void realizarAccionesTurno(){}
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        evolucionador = new Evolucionador();
        rangoAtaque = new RangoAtaque(3,posicion);
    }
    /*
    public void evolucionarAGuardian(){
        evolucionador.evolucionarUnidad(this,new Guardian());
    }
    public void evolucionarADevorador(){
        evolucionador.evolucionarUnidad(this,new Devorador());
    }
    */
    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
