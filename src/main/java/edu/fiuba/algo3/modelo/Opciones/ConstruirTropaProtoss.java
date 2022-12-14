package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Razas.Tropas.*;

public class ConstruirTropaProtoss extends OpcionElegible{
    public ConstruirTropaProtoss(String descripcion) {
        this.titulo = "Construir tropa protoss";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Construir");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida)) {
                construirZealotEn(celda);
            }else if (textoBotones.get(1).equals(opcionElejida)){
                construirDragonEn(celda);
            }else{
                construirScoutEn(celda);
            }

        }
    }

    public void construirZealotEn(Celda celda){
        Zealot zealot = new Zealot();
        celda.estaOcupadaPorTierra();
        ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(zealot);
        celda.ocuparPorTierra(zealot);
        celda.instanciarUnidad(zealot);
    }
    public void construirDragonEn(Celda celda){
        Dragon dragon = new Dragon();
        celda.estaOcupadaPorTierra();
        ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(dragon);
        celda.ocuparPorTierra(dragon);
        celda.instanciarUnidad(dragon);
    }

    public void construirScoutEn(Celda celda){
        Scout scout = new Scout();
        celda.estaOcupadaPorAire();
        ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(scout);
        celda.ocuparPorAire(scout);
        celda.instanciarUnidad(scout);
    }

    private Tropa obtenerTropaAConstruir() {
        // TODO: Mostrar ventana con opciones.
        /* Opciones de tropas: Zealot, Dragon, Scout*/

        return tropaAConstruir;
    }
}



/* Nuevo:

        this.textoBotones.add("Zealot");
        this.textoBotones.add("Dragon");
        this.textoBotones.add("Scout");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {

        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida)) {
                instanciarTropaZealot(celda);
            } else if (textoBotones.get(1).equals(opcionElejida)) {
                instanciarTropaDragon(celda);
            } else {
                instanciarTropaScout(celda);
            }

        }
    }

    private void instanciarTropaZealot(Celda celda) {

    }
    private void instanciarTropaDragon(Celda celda) {

    }
    private void instanciarTropaScout(Celda celda) {

    }

 */
