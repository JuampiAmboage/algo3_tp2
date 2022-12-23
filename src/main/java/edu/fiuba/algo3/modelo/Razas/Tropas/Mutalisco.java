package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierraYAire;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;

import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Mutalisco extends TropaAerea implements UnidadEvolucionable {
    public Mutalisco(){
        super();
        this.ataque = new AtacarTierraYAire();
        this.costoEnMinerales = 100;
        this.costoEnGas = 100;
        this.tiempoConstruccion = 4;
        this.danioTerrestre = 9;
        this.danioAereo = 9;
        this.suministro = 4;
        this.vida = new Vida(80);
        this.edificioNecesario = new Criadero();
        this.comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        this.opciones.add(new Mutar(obtenerDescripcion()));
        this.opciones.add(new MoverAerea("zerg"));
        this.opciones.add(new AtaqueTropaAerea("zerg"));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/mutalisco.png";
        this.nombreUnidad = "Mutalisco";


    }

    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,3,posicion);
    }

    public void mutar(UnidadEvolucionada unidadPostMutacion){
        Celda celda = Mapa.getInstance().obtenerCelda(this.posicion);
        this.esUsable();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.agregarUnidad((Unidad) unidadPostMutacion);
        comunidadZerg.quitarUnidad(this);
        celda.desocuparPorAire();
        celda.ocuparPorAire((TropaAerea) unidadPostMutacion);
        celda.instanciarUnidad((Unidad) unidadPostMutacion);
    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;
        cantidadAtaques = 0;
    }

    public String obtenerSprite() { return rutaSprite; }


    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
