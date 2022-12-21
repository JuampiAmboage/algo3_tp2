package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierraYAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Hidralisco extends TropaTerrestre{
    public Hidralisco() {
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 10;
        danioAereo = 10;
        suministro = 2;
        edificioNecesario = new Guarida();
        vida = new Vida(80);
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        //opciones.add(new TropaTerrestreAtacaTierra(obtenerDescripcion()));
        //opciones.add(new TropaTerrestreAtacaAire(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/hidralisco.png";
        opciones.add(new MoverTerrestre("zerg"));
    }

    @Override
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,4,posicion);

    }
    public void realizarAccionesTurno(){vida.pasarTurno();
        cantidadMovimientos = 0;
    }


    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
