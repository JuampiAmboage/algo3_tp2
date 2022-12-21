package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.*;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    private Stage escenarioPrimario;
    private BorderPane layoutRaiz;
    private ControladorVistaRaiz controladorVistaRaiz;
    private ControladorVistaMapa controladorVistaMapa;
    private ControladorVistaMenuJugadorUno controladorVistaMenuJugadorUno;
    private ControladorVistaMenuJugadorDos controladorVistaMenuJugadorDos;
    private double[] tamanioDelEscenario = new double[2];

    private Partida partida;
    public static void main(String[] args) {
        launch();
    }

    public void terminarPartida(String ganador){
        try {
            this.controladorVistaRaiz.mostrarMenuBar();
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("/vistaJuego/VistaFinDePartida.fxml")
            );
            AnchorPane vistaFin = (AnchorPane) cargador.load();

            vistaFin.setMaxSize(this.tamanioDelEscenario[0], this.tamanioDelEscenario[1]);

            this.layoutRaiz.setCenter(vistaFin);

            ControladorVistaFinDePartida controlador = cargador.getController();
            controlador.mostrarPantallaFinal(ganador);

        } catch (IOException e) { e.printStackTrace(); }
    }
    @Override
    public void start(Stage escenario) {
        this.escenarioPrimario = escenario;
        this.escenarioPrimario.setResizable(false);

        inicializarlayoutRaiz();

        this.tamanioDelEscenario[0] = this.layoutRaiz.getScaleX();
        this.tamanioDelEscenario[1] = this.layoutRaiz.getScaleY();

        this.controladorVistaRaiz.mostrarMenuBar();

        mostrarVistaInicio();
    }

    public void establecerPartida(Partida partida){ this.partida = partida; this.partida.establecerApp(this); }

    public void inicializarlayoutRaiz() {
        try {
            FXMLLoader cargador = new FXMLLoader();

            cargador.setLocation(
                    App.class.getResource("/VistaRaiz.fxml")
            );

            this.layoutRaiz = (BorderPane) cargador.load();

            Scene escena = new Scene(this.layoutRaiz);
            this.escenarioPrimario.setScene(escena);
            this.escenarioPrimario.show();

            this.controladorVistaRaiz = cargador.getController();
            this.controladorVistaRaiz.setApp(this);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarVistaInicio() {
        try {
            this.controladorVistaRaiz.mostrarMenuBar();
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("/VistaInicio.fxml")
            );
            AnchorPane vistaInicio = (AnchorPane) cargador.load();

            vistaInicio.setMaxSize(this.tamanioDelEscenario[0], this.tamanioDelEscenario[1]);

            this.layoutRaiz.setCenter(vistaInicio);

            ControladorVistaInicio controlador = cargador.getController();
            controlador.setApp(this);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarVistaConfiguracionPartida() {
        try {
            this.controladorVistaRaiz.mostrarMenuBar();

            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("/VistaConfiguracionPartida.fxml")
            );
            AnchorPane vistaConfiguracionPartida = (AnchorPane) cargador.load();

            vistaConfiguracionPartida.setMaxSize(this.tamanioDelEscenario[0], this.tamanioDelEscenario[1]);

            this.layoutRaiz.setCenter(vistaConfiguracionPartida);

            ControladorVistaConfiguracionPartida controlador = cargador.getController();
            controlador.setApp(this);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarVistaJuego(String[] perfiles, String[] nombresDeJugadores) {
        mostrarVistaJugadorUno(perfiles[0], nombresDeJugadores[0]);
        mostrarVistaJugadorDos(perfiles[1], nombresDeJugadores[1]);
        mostrarVistaMapa();
    }

    private void mostrarVistaJugadorUno(String perfil, String nombre) {
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("/vistaJuego/VistaMenuJugadorUno.fxml")
            );
            VBox VistaMenuJugadorUno = (VBox) cargador.load();

            ControladorVistaMenuJugadorUno controladorVistaMenuJugadorUno = cargador.getController();
            controladorVistaMenuJugadorUno.establecerPerfil(perfil, nombre, this);

            this.controladorVistaMenuJugadorUno = controladorVistaMenuJugadorUno;

            this.controladorVistaMenuJugadorUno.establecerAlmacenamiento(this.partida.obtenerAlmacenamiento(1));

            this.layoutRaiz.setLeft(VistaMenuJugadorUno);

        } catch (IOException e) { e.printStackTrace(); }
    }

    private void mostrarVistaJugadorDos(String perfil, String nombre) {
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("/vistaJuego/VistaMenuJugadorDos.fxml")
            );
            VBox VistaMenuJugadorDos = (VBox) cargador.load();

            ControladorVistaMenuJugadorDos controladorVistaMenuJugadorDos = cargador.getController();
            controladorVistaMenuJugadorDos.establecerPerfil(perfil, nombre, this);

            this.controladorVistaMenuJugadorDos = controladorVistaMenuJugadorDos;

            this.controladorVistaMenuJugadorDos.establecerAlmacenamiento(this.partida.obtenerAlmacenamiento(2));

            this.layoutRaiz.setRight(VistaMenuJugadorDos);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarVistaMapa() {
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(
                    App.class.getResource("/vistaJuego/VistaMapa.fxml")
            );
            BorderPane vistaMapa = (BorderPane) cargador.load();

            this.layoutRaiz.setCenter(vistaMapa);

            this.controladorVistaRaiz.ocultarMenuBar();

            ControladorVistaMapa controladorVistaMapa = cargador.getController();
            this.controladorVistaMapa = controladorVistaMapa;
            controladorVistaMapa.establecerApp(this);
            controladorVistaMapa.mostrarMapa();

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void mostrarMenu(ArrayList<OpcionElegible> opciones, Celda celda) {

        if (this.partida.quienJuega() == 1) {
            controladorVistaMenuJugadorUno.activar();
            controladorVistaMenuJugadorUno.mostrarOpciones(opciones, celda);
        } else {
            controladorVistaMenuJugadorDos.activar();
            controladorVistaMenuJugadorDos.mostrarOpciones(opciones, celda);
        }
    }

    public void gestionarPasarTurno(ControladorVistaMenuJugadores controlador) {
        this.partida.finDeTurno();
        controlador.limpiarMenu();

        if (controlador.equals(this.controladorVistaMenuJugadorUno)){
            this.controladorVistaMenuJugadorDos.activar();
            actualizarMapa();
            this.controladorVistaMenuJugadorUno.establecerAlmacenamiento(this.partida.obtenerAlmacenamiento(1));
        } else {
            this.controladorVistaMenuJugadorUno.activar();
            actualizarMapa();
            this.controladorVistaMenuJugadorDos.establecerAlmacenamiento(this.partida.obtenerAlmacenamiento(2));
        }
    }

    public void actualizarMapa() {
        this.controladorVistaMapa.actualizarMapa();
        this.controladorVistaMenuJugadorUno.establecerAlmacenamiento(this.partida.obtenerAlmacenamiento(1));
        this.controladorVistaMenuJugadorDos.establecerAlmacenamiento(this.partida.obtenerAlmacenamiento(2));
    }

    public ArrayList<Celda> obtenerCeldasConExtractor() {
        return this.controladorVistaMapa.obtenerCeldasConExtractor();
    }


    public void salir() {
        this.escenarioPrimario.close();
    }

    public void mostrarTurno(String quienJuega) {
        this.escenarioPrimario.setTitle(quienJuega);
    }

    public static void lanzarWarning(String advertencia) {
        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setHeaderText(null);
        warning.setTitle("Atencion");
        warning.setContentText(advertencia);
        warning.showAndWait();
    }

}