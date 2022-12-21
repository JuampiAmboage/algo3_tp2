package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;

import java.util.ArrayList;

public class TropaTerrestreAtacaAire extends OpcionElegible{

    public TropaTerrestreAtacaAire() {
        this.titulo = "Ataque aereo";
        this.textoBotones.add("Atacar");
    }

    public void gestionarClick(Celda celdaAtacante, String opcionElegida ) {
        Tropa tropaAtacante = (Tropa) celdaAtacante.obtenerOcupanteTerrestre();.
        int posicion;

        int i = 0;
        for (String opcion : this.textoBotones) {
            if (opcion.equals(opcionElegida)) {
                posicion = i;
                break;
            }
            i++;
        }

        Posicion posicionAAtacar = this.posicionesEnemigas.get(posicion);

        try{
            celdaAtacante.estaOcupadaPorAire();
        }
        catch (CeldaOcupada celdaOcupada) {
            //TropaAerea tropaAtacada = celdaAtacado.obtenerOcupanteAereo();
            //tropaAtacante.atacarAire(tropaAtacada);
        }
    }
}
