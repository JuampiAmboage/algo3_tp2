package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.AmoSupremo;

public class DetectarTropasInvisibles extends OpcionElegible{

    public DetectarTropasInvisibles(String descripcion) {
        this.titulo = "Detectar tropas invisibles";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Detectar";
    }
    public void gestionarClick(Celda celda) {
        AmoSupremo amoSupremo = (AmoSupremo) celda.obtenerOcupanteTerrestre();
        amoSupremo.localicarZealots();
        amoSupremo.compararTropasDetectadasEntreTurnos();
    }
}
