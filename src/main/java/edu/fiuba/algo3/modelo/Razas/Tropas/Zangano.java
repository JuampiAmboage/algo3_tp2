package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Opciones.AsignarTrabajoEnExtractor;
import edu.fiuba.algo3.modelo.Opciones.AsignarTrabajoEnNodoMineral;
import edu.fiuba.algo3.modelo.Opciones.EvolucionarAEdificio;
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
        opciones.add(new EvolucionarAEdificio(obtenerDescripcion()));
        opciones.add(new AsignarTrabajoEnExtractor(obtenerDescripcion()));
        opciones.add(new AsignarTrabajoEnNodoMineral(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/zangano.png";
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
            evaluarDistanciaAExtractor(extractorDondeTrabaja);
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
        if (recursoDeLaCelda instanceof NodoMineral)
            this.asignarTrabajoEnNodo(recursoDeLaCelda);
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
        comunidad.agregarUnidad(edificioNuevo);
        comunidad.quitarUnidad(this);
    }
    public void revisarEstadoLaboral(){
        if(extractorDondeTrabaja != null || nodoMineralDondeTrabaja != null) {
            throw new ZanganoYaEmpleado();
        }
    }

    @Override
    public void mostrarDescripcion() {
        System.out.println("-Zangano-");
        System.out.println("Se lo puede evolucionar a edificio o asignar trabajo en una celda con recursos. De zángano no tiene nada. \n");
        System.out.println("Vida actual: "+ this.vida.getVidaActual());
        if(this.extractorDondeTrabaja != null || nodoMineralDondeTrabaja != null)
            System.out.println("Estado laboral: Empleado.");
        else
            System.out.println("Estado laboral: Cesante.");
    }
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
