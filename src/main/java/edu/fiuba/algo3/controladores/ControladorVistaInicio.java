package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControladorVistaInicio {

    @FXML
    private Button botonIniciarJuego;
    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void gestionarBotonEnAccionIniciarJuego() {
        this.botonIniciarJuego.disableProperty();
        this.app.mostrarVistaConfiguracionPartida();
    }

}