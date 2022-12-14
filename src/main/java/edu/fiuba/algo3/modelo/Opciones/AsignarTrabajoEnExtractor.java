package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AsignarTrabajoEnExtractor extends OpcionElegible{

    public AsignarTrabajoEnExtractor(String descripcion) {
        this.titulo = "Asignar trabajo en extractor";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Asignar trabajo";
    }

    public void gestionarClick(Celda celdaZangano) {
        Celda celdaExtractor = obtenerCeldaExtractor();
        Unidad extractor = celdaExtractor.obtenerOcupanteTerrestre();
        Zangano zangano = (Zangano) celdaZangano.obtenerOcupanteTerrestre();
        zangano.revisarEstadoLaboral();
        zangano.asignarTrabajoEnExtractor((Extractor) extractor);
    }

    private Celda obtenerCeldaExtractor() {
        // TODO: Esperar clcik en extractor.

        return celda;
    }

}
