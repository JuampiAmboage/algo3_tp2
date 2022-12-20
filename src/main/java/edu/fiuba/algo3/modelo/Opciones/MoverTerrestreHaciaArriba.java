package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverTerrestreHaciaArriba extends OpcionElegible{
    public MoverTerrestreHaciaArriba(String descripcion, String pertenencia) {
        this.titulo = "Mover hacia arriba";
        this.textoBotones.add("Mover");
        this.pertenceA = pertenencia;
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverArriba(); }
}
