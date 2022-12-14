package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.UnidadEvolucionada;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class Mutar extends OpcionElegible{
    public Mutar(String descripcion) {
        this.titulo = "Mutar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = this.titulo;
    }
    public void gestionarClick(Celda celda, UnidadEvolucionada unidadEvolucionada) {
        Mutalisco mutalisco = (Mutalisco) celda.obtenerOcupanteTerrestre();
        mutalisco.mutar(unidadEvolucionada);
    }
}
