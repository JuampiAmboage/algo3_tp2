package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class AtaqueTropaAerea  extends OpcionElegible {
    public AtaqueTropaAerea(String descripcion) {
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
