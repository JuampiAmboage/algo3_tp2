package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class AsignarTrabajoEnExtractor extends OpcionElegible{

    public AsignarTrabajoEnExtractor(String descripcion) {
        this.titulo = "Asignar trabajo en extractor";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Asignar trabajo";
    }


    /*public void gestionarClick(Celda celda) {
        Zangano zanganoQueVaATrabajar = (Zangano) celda.obtenerOcupante();
        zanganoQueVaATrabajar.asignarTrabajoEnExtractor();
    }*/
}
