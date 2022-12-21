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
        opciones.add(new AsignarTrabajoEnExtractor(obtenerDescripcion()));
        opciones.add(new AsignarTrabajoEnNodoMineral(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/zangano.png";

    }

    @Override
    public void ocuparCelda(Celda celda){
        Celda celdaActual = Mapa.getInstance().obtenerCelda(this.posicion);
        celda.estaOcupadaPorTierra();
        celda.ocuparPorTierra(this);
        celdaActual.desocuparPorTierra();
        this.cantidadMovimientos++;
    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;
        if(nodoMineralDondeTrabaja != null)
            comunidad.aniadirMineral(extraerMineral());
    }

    public void asignarTrabajoEnExtractor(Unidad extractorQueContrata){
        this.esUsable();
        if(extractorQueContrata instanceof Extractor){
            evaluarDistanciaAExtractor((Extractor) extractorQueContrata);
            ((Extractor) extractorQueContrata).agregarTrabajador(this);
            this.extractorDondeTrabaja = (Extractor) extractorQueContrata;
        }
        else
            throw new ZanganoLejosDeExtractor();
    }

    public void evaluarDistanciaAExtractor(Extractor extractor){
        if(this.posicion.solicitarDistanciaAUnidad(extractor) >= 2)
            throw new ZanganoLejosDeExtractor();
    }

    public void asignarTrabajoEnNodo(Recurso recursoDeLaCelda){
        this.esUsable();
        if (recursoDeLaCelda instanceof NodoMineral) {
            this.nodoMineralDondeTrabaja = (NodoMineral) recursoDeLaCelda;
            this.reacondicionarOpcionesPostContratacionEnNodo(5);
        }
        else
            throw new ZanganoEnDistintaACeldaANodoMineral();
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

    public void reacondicionarOpcionesPostContratacionEnNodo(int opcionQueNoEsAsignarTrabajoElegido){
        for(int i=0;i<4;i++)
            opciones.remove(i);
        opciones.remove(opcionQueNoEsAsignarTrabajoElegido);
    }
    public void reacondicionarOpcionesPostDespido(){
        opciones.clear();
        opciones.add(new MoverTerrestre("zerg"));
        opciones.add(new EvolucionarAEdificio(obtenerDescripcion()));
        opciones.add(new AsignarTrabajoEnExtractor(obtenerDescripcion()));
        opciones.add(new AsignarTrabajoEnNodoMineral(obtenerDescripcion()));
    }
}
