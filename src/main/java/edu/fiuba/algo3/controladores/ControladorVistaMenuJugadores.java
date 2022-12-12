package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Objects;


public abstract class ControladorVistaMenuJugadores {
    protected String perfil;
    protected String nombre;
    protected Accordion acordeon;

    protected abstract void establecerNombre(String nombre);
    public abstract void establecerPerfil(String perfil, String nombre);
    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    protected ArrayList<OpcionElegible> eliminarOpcionesInvalidas(ArrayList<OpcionElegible> opciones) {
        // TODO: Si la pertenencia de una opcion coincide con la del perfil, queda, si no se elimina.
        // TODO: Si la pertenencia es null significa que pertenence a ambos perfiles, la opcion queda.

        return opciones;

    }

    public void mostrarOpciones(ArrayList<OpcionElegible> opciones){
        limpiarMenu();

        opciones = eliminarOpcionesInvalidas(opciones);

        int cantidadDeMenus = opciones.toArray().length;
        TitledPane[] titledPane = new TitledPane[cantidadDeMenus];

        instanciarAcordeon();

        for (int i = 0; i < cantidadDeMenus; i++) {
            AnchorPane nuevoAnchorPane = new AnchorPane();
            nuevoAnchorPane.setId("anchorPane_"+i);

            // TODO: (opciones.get(i)).obtenerTitulo() -> String
            // titledPane[i] = new TitledPane(opciones.get(i), nuevoAnchorPane);
            titledPane[i].setId("titlePane_"+i);
        }
        acordeon.getPanes().addAll(titledPane);

        mostrarEnVBox();
    }

    protected void instanciarAcordeon() {
        this.acordeon = new Accordion();
        this.acordeon.setId("acordeon");
    }

    protected abstract void limpiarMenu();
    protected abstract void mostrarEnVBox();
}

