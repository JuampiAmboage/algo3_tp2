package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.NexoMineral;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;

public class ConstruirNexoMineral extends OpcionElegible{

    public ConstruirNexoMineral(String descripcion) {
        this.titulo = "Construir nexo Mineral";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    public void gestionarClick(Celda celda) {
        ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda,new NexoMineral((NodoMineral) celda.obtenerRecurso()));
    }
}
