package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Recursos.Volcan;

public class ConstruirAsimilador extends OpcionElegible {

    public ConstruirAsimilador(String descripcion) {
        this.titulo = "Construir asimilador";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    public void gestionarClick(Celda celda) {
        ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda,new Asimilador((Volcan) celda.obtenerRecurso()));
    }
}
