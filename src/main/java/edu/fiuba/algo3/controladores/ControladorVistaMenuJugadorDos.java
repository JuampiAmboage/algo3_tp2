package edu.fiuba.algo3.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ControladorVistaMenuJugadorDos extends ControladorVistaMenuJugadores {

    @FXML
    protected ImageView imagenPerfil;
    @FXML
    protected Label nombrePerfil;

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
    public void mostrarOpciones(ArrayList<String> opciones) {

    }
}
