package edu.fiuba.algo3.controladores;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class Boton {
    private int fila, columna;
    private Button boton;

    private ControladorVistaMapa controladorMapa;

    public Boton(int fila, int columna, ControladorVistaMapa controladorMapa) {
        this.controladorMapa = controladorMapa;

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
        this.controladorMapa.gestionarClickEnCelda(this.fila, this.columna, this.boton);
    }

}
