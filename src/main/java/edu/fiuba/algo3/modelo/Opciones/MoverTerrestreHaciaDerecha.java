package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;

public class MoverTerrestreHaciaDerecha extends OpcionElegible{
    public MoverTerrestreHaciaDerecha(String descripcion, String pertenencia) {
        this.titulo = "Mover a la derecha";
        this.textoBotones.add("Mover");
        this.pertenceA = pertenencia;

    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        TropaTerrestre tropaAMovilizar = (TropaTerrestre) celda.obtenerOcupanteTerrestre();
        tropaAMovilizar.moverDerecha();
    }
}
