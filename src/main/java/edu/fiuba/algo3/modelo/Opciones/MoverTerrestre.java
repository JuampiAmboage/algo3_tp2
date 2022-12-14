package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;

public class MoverTerrestre extends OpcionElegible{
    public MoverTerrestre(String pertenencia) {
        this.titulo = "Mover";
        this.textoBotones.add("Arriba");
        this.textoBotones.add("Abajo");
        this.textoBotones.add("Izquierda");
        this.textoBotones.add("Derecha");
        this.pertenceA = pertenencia;

    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {

        if (textoBotones.contains(opcionElejida)) {

            TropaTerrestre tropa = (TropaTerrestre) celda.obtenerOcupanteTerrestre();

            if (textoBotones.get(0).equals(opcionElejida)) {
                tropa.moverArriba();
            }else if (textoBotones.get(1).equals(opcionElejida)){
                tropa.moverAbajo();
            }
            else if (textoBotones.get(2).equals(opcionElejida)) {
                tropa.moverIzquierda();
            }
            else{
                tropa.moverDerecha();
            }

        }
    }


}
