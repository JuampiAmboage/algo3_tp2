package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.EvolucionIncompatibleConTropaEvolucionableActual;
import edu.fiuba.algo3.modelo.Excepciones.ZanganoEnDistintaACeldaANodoMineral;
import edu.fiuba.algo3.modelo.Excepciones.ZanganoSinNodoMineralAsignado;
import edu.fiuba.algo3.modelo.Excepciones.ZanganoYaEmpleado;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;
import edu.fiuba.algo3.modelo.Razas.Tropas.UnidadEvolucionable;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
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
        opciones.add("Evolucionar a edificio");
        opciones.add("Trabajar en un extractor");
        opciones.add("Trabajar en un nodo mineral");
        opciones.add("Extraer mineral");
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
        if(this.posicion.solicitarDistanciaAUnidad(extractorQueContrata) == 1) {
            this.extractorDondeTrabaja = extractorQueContrata;
        }
        this.extractorDondeTrabaja = extractorQueContrata;
    }

    public void asignarTrabajoEnNodo(NodoMineral nodoMineral){
        this.esUsable();
        /*if(this.posicion.solicitarDistanciaA(nodoMineral) == 0) {
            this.nodoMineralDondeTrabaja = nodoMineral;
        }
        else
            throw new ZanganoEnDistintaACeldaANodoMineral();*/


    }

    public int extraerMineral(){
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
}
