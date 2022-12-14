package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class AsignarTrabajoEnNodoMineral extends OpcionElegible{
    public AsignarTrabajoEnNodoMineral(String descripcion) {
        this.titulo = "Asignar trabajo en nodo mineral";
        this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Asignar trabajo";
    }

    public void gestionarClick(Celda celda) {
        Zangano zanganoQueVaATrabajar = (Zangano) celda.obtenerOcupanteTerrestre();
        //zanganoQueVaATrabajar.asignarTrabajoEnNodo();
    }
}

