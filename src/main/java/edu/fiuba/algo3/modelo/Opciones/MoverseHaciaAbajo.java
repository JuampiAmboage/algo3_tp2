package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverseHaciaAbajo extends OpcionElegible{
    public MoverseHaciaAbajo(String descripcion) {
        this.titulo = "Mover hacia abajo";
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Mover");
    }
    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverAbajo();}
}
