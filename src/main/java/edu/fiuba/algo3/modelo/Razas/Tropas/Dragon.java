package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierraYAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.Acceso;

import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Dragon extends TropaTerrestre{

    public Dragon() {
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 125;
        costoEnGas = 50;
        tiempoConstruccion = 6;
        danioTerrestre = 20;
        danioAereo = 20;
        suministro = 3;
        edificioNecesario = new Acceso();
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        vida = new VidaConEscudo(100,80);
        //opciones.add(new TropaTerrestreAtacaTierra(obtenerDescripcion()));
        //opciones.add(new TropaTerrestreAtacaAire(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/protoss/dragon.png";
        opciones.add(new MoverTerrestre("protoss"));
        this.nombreUnidad = "Dragón";

    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;

    }


    public void instanciacionInicial(Posicion posicionAColocar){
        posicion = posicionAColocar;
        rangoAtaque = new RangoAtaque(this,4,posicion);
    }

    public int obtenerEscudo(){return vida.getEscudoActual();}

    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
