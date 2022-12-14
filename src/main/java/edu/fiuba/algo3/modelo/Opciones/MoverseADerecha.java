package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverseADerecha extends OpcionElegible{
    public MoverseADerecha(String descripcion) {
        this.titulo = "Mover a la derecha";
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Mover");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverDerecha();
    }
}
