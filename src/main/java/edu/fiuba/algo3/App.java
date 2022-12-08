package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import edu.fiuba.algo3.controladores.ControladorVistaRaiz;
import edu.fiuba.algo3.controladores.ControladorVistaInicio;
import edu.fiuba.algo3.controladores.ControladorVistaConfiguracionPartida;

public class App extends Application {

    private Stage escenarioPrimario;
    private BorderPane layoutRaiz;
    private double[] tamanioDelEscenario = new double[2];

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage escenario) {
        this.escenarioPrimario = escenario;
        this.escenarioPrimario.setTitle("Conquer the universe");
        this.escenarioPrimario.setFullScreen(false);
        this.escenarioPrimario.setResizable(false);

        inicializarlayoutRaiz();

        this.tamanioDelEscenario[0] = this.layoutRaiz.getScaleX();
        this.tamanioDelEscenario[1] = this.layoutRaiz.getScaleY();

        mostrarVistaInicio();
    }

    public void inicializarlayoutRaiz() {
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("VistaRaiz.fxml")
            );
            this.layoutRaiz = (BorderPane) cargador.load();

            Scene escena = new Scene(this.layoutRaiz);
            this.escenarioPrimario.setScene(escena);
            this.escenarioPrimario.show();

            ControladorVistaRaiz controlador = cargador.getController();
            controlador.setApp(this);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarVistaInicio() {
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("VistaInicio.fxml")
            );
            AnchorPane VistaInicio = (AnchorPane) cargador.load();

            VistaInicio.setMaxSize(this.tamanioDelEscenario[0], this.tamanioDelEscenario[1]);

            this.layoutRaiz.setCenter(VistaInicio);

            ControladorVistaInicio controlador = cargador.getController();
            controlador.setApp(this);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarVistaConfiguracionPartida() {
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("VistaConfiguracionPartida.fxml")
            );
            AnchorPane vistaConfiguracionPartida = (AnchorPane) cargador.load();

            vistaConfiguracionPartida.setMaxSize(this.tamanioDelEscenario[0], this.tamanioDelEscenario[1]);

            this.layoutRaiz.setCenter(vistaConfiguracionPartida);

            ControladorVistaConfiguracionPartida controlador = cargador.getController();
            controlador.setApp(this);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarVistaJuego() {}

    public void salir() {
        this.escenarioPrimario.close();
    }

}