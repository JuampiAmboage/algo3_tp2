package edu.fiuba.algo3.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControladorVistaFinDePartida {

    @FXML
    private Label textoFinal;

    public void mostrarPantallaFinal(String ganador) {
        textoFinal.setText(ganador + "ha ganado la partida");
    }

}
