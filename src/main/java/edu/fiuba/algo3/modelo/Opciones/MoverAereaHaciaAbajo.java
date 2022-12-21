package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;

public class MoverAereaHaciaAbajo extends OpcionElegible{

    public MoverAereaHaciaAbajo(String descripcion, String pertenencia) {
        this.titulo = "Mover hacia abajo";
        this.textoBotones.add("Mover");
        this.pertenceA = pertenencia;
    }
    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        TropaAerea tropaAMovilizar = (TropaAerea) celda.obtenerOcupanteAereo();
        tropaAMovilizar.moverAbajo();}
}

