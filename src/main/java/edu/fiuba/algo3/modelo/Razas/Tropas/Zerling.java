package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierra;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorAire;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorTierra;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Zerling extends TropaTerrestre {
    public Zerling(){
        super();
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
        opciones.add(new AtacarPorTierra(obtenerDescripcion()));
        opciones.add(new AtacarPorAire(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/zerlilng.png";
    }

    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,1,posicion);

    }
    public void realizarAccionesTurno(){vida.pasarTurno();
        cantidadMovimientos = 0;
    }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }
    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
