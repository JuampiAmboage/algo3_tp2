package edu.fiuba.algo3.controladores;

import javafx.scene.Node;
import javafx.scene.control.Button;


public class Boton {
    private int fila, columna;
    private Button boton;

    public Boton(int fila, int columna) {
        this.boton = new Button();

        this.boton.setPrefSize(70.0, 70.0);
        this.boton.setOnAction(e->gestionarClickEnCelda());
        this.boton.setId("boton");

        this.fila = fila;
        this.columna = columna;
    }

    public Node obtenerBoton(){
        return this.boton;
    }

    private void gestionarClickEnCelda(){
        System.out.println(fila + ", " + columna);
    }

}
