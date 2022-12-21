package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;

public class AtaqueTropaTerrestre extends OpcionElegible{
    public AtaqueTropaTerrestre(String descripcion) {
        this.titulo = "Atacar";
        this.textoBotones.add("Atacar tropa aérea");
        this.textoBotones.add("Atacat tropa en tierra");
    }
    public void gestionarClick(Celda celda, String opcionElegida){
        if (textoBotones.contains(opcionElegida)) {

        }else{
        }
    }
}
