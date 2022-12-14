package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverseHaciaArriba extends OpcionElegible{
    public MoverseHaciaArriba(String descripcion) {
        this.titulo = "Mover hacia arriba";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Mover";
    }
    @Override
    public void gestionarClick(Celda celda) {  Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverArriba(); }
}
