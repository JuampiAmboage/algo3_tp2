package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierraYAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Espiral;

import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Mutalisco extends TropaAerea implements UnidadEvolucionable {
    public Mutalisco(){
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 100;
        costoEnGas = 100;
        tiempoConstruccion = 4;
        danioTerrestre = 9;
        danioAereo = 9;
        suministro = 4;
        vida = new Vida(80);
        edificioNecesario = new Espiral();
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        //opciones.add(new TropaAereaAtacaTierra(obtenerDescripcion()));
        //opciones.add(new TropaAereaAtacaTierra(obtenerDescripcion()));
        opciones.add(new Mutar(obtenerDescripcion()));
        opciones.add(new MoverAerea("zerg"));
        this.nombreUnidad = "Mutalisco";


    }

    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,3,posicion);
    }

    public void mutar(UnidadEvolucionada unidadPostMutacion){
        this.esUsable();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.agregarUnidad((Unidad) unidadPostMutacion);
        comunidadZerg.quitarUnidad(this);
    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;

    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }


    public String obtenerSprite() { return null; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
