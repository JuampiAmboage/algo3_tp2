package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.UnidadEvolucionable;
import edu.fiuba.algo3.modelo.Razas.Tropas.UnidadEvolucionada;

public class Engendrar extends OpcionElegible{

    public Engendrar(String descripcion) {
        this.titulo = "Engendrar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = this.titulo;
    }

    public void gestionarClick(Celda celda) {
        Tropa unidadAEngendrar = obtenerTropa();
        Criadero criadero = (Criadero) celda.obtenerOcupanteTerrestre();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidad(criadero,unidadAEngendrar);
    }

    private Tropa obtenerTropa() {
        // TODO: Mostrar ventana con opciones.
        /* Opciones de tropas: Zangano, Zerling, Hidralisco, Mutalisco, Amo Supremo */

        return tropa;
    }
}
