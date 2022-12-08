package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Espiral;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Mutalisco extends TropaAerea implements UnidadEvolucionable {
    public Mutalisco(){
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 9;
        danioAereo = 9;
        suministro = 4;
        vida = new Vida(80);
        edificioNecesario = new Espiral();
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        comunidad.aniadirSuministro(suministro);

    }

    public void mutar(Tropa unidadPostMutacion){
        if(unidadPostMutacion.getClass().equals(Guardian.class) || unidadPostMutacion.getClass().equals(Devorador.class)) {
            ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
            comunidadZerg.agregarUnidad(unidadPostMutacion);
            comunidadZerg.quitarUnidad(this);
        }
    }
    public void realizarAccionesTurno(){}
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,3,posicion);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
