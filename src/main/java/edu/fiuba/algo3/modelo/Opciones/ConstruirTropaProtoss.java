package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;

public class ConstruirTropaProtoss extends OpcionElegible{
    public ConstruirTropaProtoss(String descripcion) {
        this.titulo = "Construir tropa protoss";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    public void gestionarClick(Celda celda) {
        Tropa tropaAConstruir = obtenerTropaAConstruir();
        if (tropaAConstruir instanceof TropaAerea) {
            celda.estaOcupadaPorAire();
            ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(tropaAConstruir);
            celda.ocuparPorAire((TropaAerea) tropaAConstruir);
        } else {
            celda.estaOcupadaPorTierra();
            ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(tropaAConstruir);
            celda.ocuparPorTierra(tropaAConstruir);
        }
        celda.instanciarUnidad(tropaAConstruir);
    }

    private Tropa obtenerTropaAConstruir() {
        // TODO: Mostrar ventana con opciones.
        /* Opciones de tropas: Zealot, Dragon, Scout*/

        return tropaAConstruir;
    }
}
