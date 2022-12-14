package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class Engendrar extends OpcionElegible{

    public Engendrar(String descripcion) {
        this.titulo = "Engendrar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = this.titulo;
    }

    public void gestionarClick(Celda celda, Tropa unidadAEngendrar) {
        Criadero criadero = (Criadero) celda.obtenerOcupanteTerrestre();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidad(criadero,unidadAEngendrar);
    }
}
