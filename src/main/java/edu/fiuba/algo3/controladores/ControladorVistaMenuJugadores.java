package edu.fiuba.algo3.controladores;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class ControladorVistaMenuJugadores {
    protected String perfil;
    protected String nombre;

    public abstract void establecerPerfil(String perfil, String nombre);

    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    protected abstract void establecerNombre(String nombre);

}

