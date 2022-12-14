package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverseHaciaArriba extends OpcionElegible{
    public MoverseHaciaArriba(String descripcion) {
        this.titulo = "Mover hacia arriba";
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Mover");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {  Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverArriba(); }
}
