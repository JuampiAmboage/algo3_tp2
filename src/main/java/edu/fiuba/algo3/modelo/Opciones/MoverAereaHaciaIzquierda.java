package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class MoverAereaHaciaIzquierda extends OpcionElegible {
    public MoverAereaHaciaIzquierda(String descripcion, String pertenencia) {
        this.titulo = "Mover a la izquierda";
        this.textoBotones.add("Mover");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Tropa tropaAMovilizar = (Tropa) celda.obtenerOcupanteAereo();
        tropaAMovilizar.moverIzquierda(); }
}
