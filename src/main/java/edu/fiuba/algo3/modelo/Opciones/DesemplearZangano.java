package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class DesemplearZangano extends OpcionElegible{
    public DesemplearZangano(String descripcion) {
        this.titulo = "Desocupar nodo";
        this.pertenceA = "zerg";
        this.textoBotones.add("Desocupar nodo");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Extractor extractor = (Extractor) celda.obtenerOcupanteTerrestre();
        extractor.liberarTrabajador();
    }
}
