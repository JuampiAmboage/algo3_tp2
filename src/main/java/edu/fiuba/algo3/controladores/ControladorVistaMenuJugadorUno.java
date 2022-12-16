package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ControladorVistaMenuJugadorUno extends ControladorVistaMenuJugadores {
    @FXML
    protected ImageView imagenPerfil;
    @FXML
    protected Label nombrePerfil;
    @FXML
    private VBox vBoxMenu;
    @FXML
    private Button botonPasarTurno;
    @FXML
    private GridPane grillaMenu;

    @Override
    public void establecerPerfil(String perfil, String nombre, App app) {
        this.app = app;

        this.perfil = perfil;
        this.activo = true;

        this.imagenPerfil.setFitWidth(100.0);
        this.imagenPerfil.setFitHeight(100.0);
        this.imagenPerfil.setImage(establecerImagen());

        establecerNombre(nombre);
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
    public void limpiarMenu() { this.vBoxMenu.getChildren().clear(); }

    public void gestionarPasarTurno() {
        desactivar();
        this.app.gestionarPasarTurno(this);
    }

    @Override
    public void activar() {
        this.botonPasarTurno.setDisable(false);
        this.activo = true;
        indicadorDeTurnoActivo();
    }

    @Override
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

}

