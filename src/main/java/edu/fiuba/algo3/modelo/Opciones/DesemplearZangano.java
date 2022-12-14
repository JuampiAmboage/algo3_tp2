package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Extractor;

public class DesemplearZangano extends OpcionElegible{
    public DesemplearZangano(String descripcion) {
        this.titulo = "Desemplear zangano";
        this.pertenceA = "zerg";
        this.textoBotones.add("Desemplear zangano");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Extractor extractor = (Extractor) celda.obtenerOcupanteTerrestre();
        extractor.liberarTrabajador();
    }

}
