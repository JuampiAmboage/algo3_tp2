package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;

public class AsignarTrabajoEnNodoMineral extends OpcionElegible{
    //Nodo mineral o nexo mineral? pertenencia =? protoss
    public AsignarTrabajoEnNodoMineral(String descripcion) {
        this.titulo = "Asignar trabajo en nodo mineral";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Asignar trabajo";
    }

    public void gestionarClick(Celda celda) {
        Zangano zanganoQueVaATrabajar = (Zangano) celda.obtenerOcupanteTerrestre();
        zanganoQueVaATrabajar.revisarEstadoLaboral();
        zanganoQueVaATrabajar.asignarTrabajoEnNodo((NodoMineral) celda.obtenerRecurso());
    }
}

