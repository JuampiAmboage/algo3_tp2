package edu.fiuba.algo3;

import edu.fiuba.algo3.Interfaz.controladores.VistaJugadorControlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private Stage escenario;
    private BorderPane rootLayout;

    //TODO: faltan los botones para instanciar la partida y registrar
    @Override
    public void start(Stage escenario) {
        this.escenario = escenario;
        this.escenario.setTitle("El mejor juego del mundo");

        initRootLayout();
    }

    public void initRootLayout() {
        try {

            FXMLLoader cargador = new FXMLLoader();

            cargador.setLocation(
                    App.class.getResource("VistaRaiz.fxml")
            );

            rootLayout = (BorderPane) cargador.load();

            Scene escena = new Scene(rootLayout);
            escenario.setScene(escena);
            escenario.show();

        } catch (IOException e) { e.printStackTrace(); }
    }

    //Todavia no se usa.
    //Solo se va a usar cuando ya los jugadores  este "registrados" y se ppueda armar la partida correctamente
    public void initLayoutJugador() {
        try {

            FXMLLoader cargador = new FXMLLoader();

            cargador.setLocation(
                    App.class.getResource("VistaJugador.fxml")
            );

            AnchorPane layoutJugador = (AnchorPane) cargador.load();

            rootLayout.setCenter(layoutJugador);

            VistaJugadorControlador controlador = cargador.getController();
            controlador.setApp(this);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        launch();
    }

}