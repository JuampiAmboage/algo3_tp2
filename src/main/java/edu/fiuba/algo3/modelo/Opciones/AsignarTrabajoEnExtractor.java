package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ZanganoLejosDeExtractor;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AsignarTrabajoEnExtractor extends OpcionElegible{

    public AsignarTrabajoEnExtractor(String descripcion) {
        this.titulo = "Asignar trabajo en extractor";
        this.pertenceA = "zerg";
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Asignar trabajo");
    }

    @Override
    public void gestionarClick(Celda celdaZangano, String opcionElejida) {
        Zangano zangano = (Zangano) celdaZangano.obtenerOcupanteTerrestre();
        zangano.revisarEstadoLaboral();

        enviarAtrabajar(zangano);
    }

    private void enviarAtrabajar(Zangano zangano) {
        for (Celda celdaConextractor : this.celdasConExtractor) {
            Extractor extractor = (Extractor) celdaConextractor.obtenerOcupanteTerrestre();
            try {
                zangano.asignarTrabajoEnExtractor(extractor);
            } catch (ZanganoLejosDeExtractor ignored) {}
        }
    }
}

