package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverseADerecha extends OpcionElegible{
    public MoverseADerecha(String descripcion) {
        this.titulo = "Mover a la derecha";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Mover";
    }

    public void gestionarClick(Celda celda) {
        Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverDerecha();
    }
}
