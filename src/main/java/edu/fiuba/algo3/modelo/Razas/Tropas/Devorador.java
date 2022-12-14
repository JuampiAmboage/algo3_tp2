package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorTierra;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorAire;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Devorador extends TropaAerea implements UnidadEvolucionada{
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
        suministro = 0;
        opciones.add(new AtacarPorTierra(obtenerDescripcion()));
        opciones.add(new AtacarPorAire(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/devorador.png";
    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;
    }

    @Override
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,5,posicion);

    }
    @Override
    public void pasarTurno() {
        estado.pasarTurno();
    }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
