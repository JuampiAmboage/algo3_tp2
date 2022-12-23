package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ZanganoLejosDeExtractor;
import edu.fiuba.algo3.modelo.Excepciones.ZanganoYaEmpleado;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class AsignarTrabajoEnExtractor extends OpcionElegible{

    public AsignarTrabajoEnExtractor() {
        this.titulo = "Asignar trabajo en extractor";
        this.pertenceA = "zerg";
        this.textoBotones.add("Asignar trabajo en extractor");
    }

    @Override
    public void gestionarClick(Celda celdaZangano, String opcionElejida) {
        Zangano zangano = (Zangano) celdaZangano.obtenerOcupanteTerrestre();
        enviarAtrabajar(zangano);
        celdaZangano.desocuparPorTierra();
    }

    private void enviarAtrabajar(Zangano zangano) {
        for (Celda celdaConextractor : this.celdasConExtractor) {
            Extractor extractor = (Extractor) celdaConextractor.obtenerOcupanteTerrestre();
            try {
                zangano.asignarTrabajoEnExtractor(extractor);
            } catch (ZanganoLejosDeExtractor | ZanganoYaEmpleado ignore) {}
        }
    }
}

