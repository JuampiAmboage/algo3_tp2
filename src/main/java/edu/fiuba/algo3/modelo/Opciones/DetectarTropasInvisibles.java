package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.AmoSupremo;

public class DetectarTropasInvisibles extends OpcionElegible{

    public DetectarTropasInvisibles(String descripcion) {
        this.titulo = "Detectar tropas invisibles";
        this.pertenceA = "zerg";
        this.textoBotones.add("Detectar");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        AmoSupremo amoSupremo = (AmoSupremo) celda.obtenerOcupanteAereo();
        amoSupremo.localicarZealots();
        amoSupremo.compararTropasDetectadasEntreTurnos();
    }

}
