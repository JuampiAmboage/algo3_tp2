package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;

public class MoverAereaHaciaIzquierda extends OpcionElegible {
    public MoverAereaHaciaIzquierda(String descripcion, String pertenencia) {
        this.titulo = "Mover a la izquierda";
        this.textoBotones.add("Mover");
        this.pertenceA = pertenencia;

    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        TropaAerea tropaAMovilizar = (TropaAerea) celda.obtenerOcupanteAereo();
        tropaAMovilizar.moverIzquierda(); }
}
