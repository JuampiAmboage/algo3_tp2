package edu.fiuba.algo3.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ControladorVistaFinDePartida {

    @FXML
    private BorderPane base;

    public void mostrarPantallaFinal(String ganador) {
        Label textoFinal = new Label();

        textoFinal.setId("textoFinal");
        textoFinal.setText(ganador + " ha ganado la partida");

        textoFinal.setMinSize(200.0,200.0);

        this.base.setCenter(textoFinal);
    }

}
