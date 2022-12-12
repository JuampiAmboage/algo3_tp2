package edu.fiuba.algo3.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;


public abstract class ControladorVistaMenuJugadores {
    protected String perfil;
    protected String nombre;
    protected Accordion acordeon;
    protected TitledPane[] titledPane;
    protected AnchorPane[] anchorPane;

    public abstract void establecerPerfil(String perfil, String nombre);

    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    protected abstract void establecerNombre(String nombre);

    public abstract void mostrarOpciones(ArrayList<String> opciones, int cantidadDeMenus);

    protected void instanciarAcordeon() {
        this.acordeon = new Accordion();
        this.acordeon.setId("acordeon");
    }

}

