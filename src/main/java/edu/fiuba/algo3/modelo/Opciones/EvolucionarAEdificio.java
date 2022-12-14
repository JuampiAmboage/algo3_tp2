package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class EvolucionarAEdificio extends OpcionElegible{

    public EvolucionarAEdificio(String descripcion) {
        this.titulo = "Evolucionar a edificio";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "evolucionar";
    }

    public void gestionarClick(Celda celdaAConstruir, Edificio edificioAConstruir) {
        Zangano zanganoAEvolucionar = (Zangano) celdaAConstruir.obtenerOcupanteTerrestre();
        ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celdaAConstruir,zanganoAEvolucionar,edificioAConstruir);
        celdaAConstruir.instanciarUnidad(edificioAConstruir);

    }
}
