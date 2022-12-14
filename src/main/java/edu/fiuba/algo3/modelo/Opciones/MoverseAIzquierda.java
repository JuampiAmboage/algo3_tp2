package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverseAIzquierda extends OpcionElegible{

    public MoverseAIzquierda(String descripcion) {
        this.titulo = "Mover a la izquierda";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Mover";
    }

    public void gestionarClick(Celda celda) {  Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverIzquierda(); }
}
