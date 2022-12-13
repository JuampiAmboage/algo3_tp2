package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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

    @Override
    public void establecerPerfil(String perfil, String nombre, App app) {
        this.app = app;

        this.perfil = perfil;

        this.imagenPerfil.setFitWidth(100.0);
        this.imagenPerfil.setFitHeight(100.0);
        this.imagenPerfil.setImage(establecerImagen());

        establecerNombre(nombre);
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
    protected void limpiarMenu() {
        this.vBoxMenu.getChildren().clear();
    }

    public void gestionarPasarTurno() {
        this.app.gestionarPasarTurno();
        this.botonPasarTurno.setDisable(true);
    }

    public void activar() { this.botonPasarTurno.setDisable(false); }

}
