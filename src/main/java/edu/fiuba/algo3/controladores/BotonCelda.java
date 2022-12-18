package edu.fiuba.algo3.controladores;

import javafx.scene.Node;
import javafx.scene.control.Button;


public class BotonCelda {
    private int fila, columna;
    public Button boton;

    private ControladorVistaMapa controladorMapa;

    public BotonCelda(int fila, int columna, ControladorVistaMapa controladorMapa) {
        this.controladorMapa = controladorMapa;

        this.boton = new Button();

        this.boton.setPrefSize(70.0, 70.0);
        this.boton.setOnAction(e->gestionarClickEnCelda());

        this.fila = fila;
        this.columna = columna;
    }

    public Button obtenerBotonNodo(){
        return this.boton;
    }

    private void gestionarClickEnCelda() { this.controladorMapa.gestionarClickEnCelda(this.fila, this.columna, this.boton); }

}
