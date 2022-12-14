package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierraYAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorTierra;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorAire;
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
        opciones.add(new AtacarPorTierra(obtenerDescripcion()));
        opciones.add(new AtacarPorAire(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/hidralisco.png";
    }

    @Override
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,4,posicion);

    }
    public void realizarAccionesTurno(){vida.pasarTurno();
        cantidadMovimientos = 0;
    }

    @Override
    public void mostrarDescripcion() {
        System.out.println("-Hidralisco-");
        System.out.println("Hizo Moai Tai y Judo. El problema es que solo hasta la primera clase. \n");
        System.out.println("Vida actual: "+ this.vida.getVidaActual());
        System.out.println("Daño aereo: "+ this.danioAereo);
        System.out.println("Danio terrestre:" + this.danioTerrestre);
    }
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
