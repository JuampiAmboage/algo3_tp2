package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.EvolucionIncompatibleConTropaEvolucionableActual;
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
        opciones.add("Extraer mineral");
        opciones.add("Trabajar en un extractor");
        opciones.add("Moverse");
    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        if(nodoMineralDondeTrabaja != null)
            comunidad.aniadirMineral(extraerMineral());
    }
    public void asignarTrabajoEnExtractor(Extractor extractorQueContrata){
        this.esUsable();
        this.extractorDondeTrabaja = extractorQueContrata;
    }

    public void asignarTrabajoEnNodo(NodoMineral nodoMineral){
        this.esUsable();
        this.nodoMineralDondeTrabaja = nodoMineral;

    }

    public int extraerMineral(){
        return nodoMineralDondeTrabaja.extraer(10);
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
}
