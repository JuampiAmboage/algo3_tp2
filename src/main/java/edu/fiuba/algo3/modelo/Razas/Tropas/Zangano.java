package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recurso;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Zangano extends TropaTerrestre {
    Extractor extractorDondeTrabaja;
    NodoMineral nodoMineralDondeTrabaja;
    public Zangano(){
        this.comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        this.costoEnGas = 0;
        this.costoEnMinerales = 25;
        this.tiempoConstruccion = 1;
        this.suministro = 1;
        this.vida = new Vida(25);
        this.edificioNecesario = new Criadero();

        opciones.add(new MoverTerrestre("zerg"));
        opciones.add(new EvolucionarAEdificio(obtenerDescripcion()));
        opciones.add(new AsignarTrabajoEnExtractor());
        opciones.add(new AsignarTrabajoEnNodoMineral(obtenerDescripcion()));

        this.establecerOpciones();

        this.rutaSprite = this.rutaSprite + "tropas/zerg/zangano.png";

    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;
        if(nodoMineralDondeTrabaja != null)
            comunidad.aniadirMineral(extraerMineral());
    }

    public void asignarTrabajoEnExtractor(Extractor extractorQueContrata){
        this.esUsable();
        evaluarDistanciaAExtractor(extractorQueContrata);
        revisarEstadoLaboral();
        extractorQueContrata.agregarTrabajador(this);
        this.extractorDondeTrabaja = extractorQueContrata;
    }

    public void evaluarDistanciaAExtractor(Extractor extractor){
        if(this.posicion.solicitarDistanciaAUnidad(extractor) >= 2)
            throw new ZanganoLejosDeExtractor();
    }

    public void asignarTrabajoEnNodo(Recurso recursoDeLaCelda){
        this.esUsable();
        if (recursoDeLaCelda instanceof NodoMineral) {
            this.nodoMineralDondeTrabaja = (NodoMineral) recursoDeLaCelda;
            this.reacondicionarOpcionesPostContratacionEnNodo();
        }
        else
            throw new ZanganoEnDistintaACeldaANodoMineral();
    }

    public void liberarDeNodo(){
        this.nodoMineralDondeTrabaja = null;
        this.establecerOpciones();
    }

    public void liberarDeExtractor(){
        this.extractorDondeTrabaja = null;
    }
    public int extraerMineral(){
        this.esUsable();
        if(nodoMineralDondeTrabaja != null){
            return nodoMineralDondeTrabaja.extraer(10);
        }
        else
            throw new ZanganoSinNodoMineralAsignado();
    }

    public void evolucionarAEdificio(Edificio edificioNuevo){
        this.estado.esUsable();
        comunidad.agregarUnidad(edificioNuevo);
        comunidad.quitarUnidad(this);
    }
    public void revisarEstadoLaboral(){
        if(extractorDondeTrabaja != null || nodoMineralDondeTrabaja != null) {
            throw new ZanganoYaEmpleado();
        }
    }
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }

    public void reacondicionarOpcionesPostContratacionEnNodo(){
        opciones.clear();
        opciones.add(new DesocuparNodo(obtenerDescripcion()));
    }
    public void establecerOpciones(){
        opciones.clear();
        opciones.add(new MoverTerrestre("zerg"));
        opciones.add(new EvolucionarAEdificio(obtenerDescripcion()));
        opciones.add(new AsignarTrabajoEnExtractor());
        opciones.add(new AsignarTrabajoEnNodoMineral(obtenerDescripcion()));
    }
}
