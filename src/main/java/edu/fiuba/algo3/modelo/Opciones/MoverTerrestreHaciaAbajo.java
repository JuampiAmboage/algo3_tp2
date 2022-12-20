package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverTerrestreHaciaAbajo extends OpcionElegible{
    public MoverTerrestreHaciaAbajo(String descripcion, String pertenencia) {
        this.titulo = "Mover hacia abajo";
        this.textoBotones.add("Mover");
    }
    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverAbajo();}
}
