package edu.fiuba.algo3.controladores;

import javafx.fxml.FXML;
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

    @Override
    public void establecerPerfil(String perfil, String nombre) {
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

}
