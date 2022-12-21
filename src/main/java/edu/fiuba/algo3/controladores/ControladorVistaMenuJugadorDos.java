package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ControladorVistaMenuJugadorDos extends ControladorVistaMenuJugadores {

    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Label nombrePerfil;
    @FXML
    protected VBox vBoxMenu;
    @FXML
    private Button botonPasarTurno;
    @FXML
    private GridPane grillaMenu;

    @FXML
    private Label gas;
    @FXML
    private Label mineral;

    @Override
    public void establecerPerfil(String perfil, String nombre, App app) {
        this.app = app;

        this.perfil = perfil;
        this.activo = false;

        this.imagenPerfil.setFitWidth(100.0);
        this.imagenPerfil.setFitHeight(100.0);
        this.imagenPerfil.setImage(establecerImagen());

        establecerNombre(nombre);
        establecerBotonPasarTurno();
        indicadorDeTurnoActivo();
    }

    @Override
    protected void establecerNombre(String nombre) {
        this.nombrePerfil.setText(nombre);
        this.nombre = nombre;
    }

    @Override
    protected void mostrarEnVBox() {
        this.vBoxMenu.getChildren().add(this.acordeon);
    }

    @Override
    public void limpiarMenu() {
        this.vBoxMenu.getChildren().clear();
    }

    private void establecerBotonPasarTurno() {
        this.botonPasarTurno.setDisable(true);
    }

    public void gestionarPasarTurno() {
        desactivar();
        this.app.gestionarPasarTurno(this);
    }

    public void activar() {
        this.botonPasarTurno.setDisable(false);
        this.activo = true;
        indicadorDeTurnoActivo();
    }

    public void desactivar() {
        this.botonPasarTurno.setDisable(true);
        this.activo = false;
        indicadorDeTurnoActivo();
    }

    @Override
    public void indicadorDeTurnoActivo() {
        if (this.activo){
            this.grillaMenu.setStyle("-fx-border-color: green");
            mostrarTurno();
        } else {
            this.grillaMenu.setStyle("-fx-border-color: red");
        }
    }

    @Override
    public void establecerAlmacenamiento(int[] almacenamiento) {
        this.almacenDeGas = almacenamiento[0] + "";
        this.almacenDeMineral = almacenamiento[1] + "";
        actualizarAlmacenamiento();
    }

    @Override
    public void actualizarAlmacenamiento() {
        this.gas.setText("Gas almacenado: " + this.almacenDeGas);
        this.mineral.setText("Mineral almacenado: " + this.almacenDeMineral);
    }

}
