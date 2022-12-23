package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Razas.Tropas.*;

public class ConstruirTropaProtoss extends OpcionElegible {
    public ConstruirTropaProtoss(String descripcion) {
        this.titulo = "Construir tropa protoss";
        this.pertenceA = "protoss";
        this.textoBotones.add("Zealot");
        this.textoBotones.add("Dragon");
        this.textoBotones.add("Scout");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida)) {
                construirZealotEn(celda);
            } else if (textoBotones.get(1).equals(opcionElejida)) {
                construirDragonEn(celda);
            } else {
                construirScoutEn(celda);
            }

        }
    }

    public void construirZealotEn(Celda celda) {
        Zealot zealot = new Zealot();
        try {
            celda.estaOcupadaPorTierra();
            zealot.existeEdificioNecesario();
            ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(zealot);
            celda.ocuparPorTierra(zealot);
            celda.instanciarUnidad(zealot);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }

    public void construirDragonEn(Celda celda) {
        Dragon dragon = new Dragon();
        try {
            celda.estaOcupadaPorTierra();
            dragon.existeEdificioNecesario();
            ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(dragon);
            celda.ocuparPorTierra(dragon);
            celda.instanciarUnidad(dragon);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }

    public void construirScoutEn(Celda celda) {
        Scout scout = new Scout();
        try {
            celda.estaOcupadaPorAire();
            scout.existeEdificioNecesario();
            ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(scout);
            celda.ocuparPorAire(scout);
            celda.instanciarUnidad(scout);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }

}