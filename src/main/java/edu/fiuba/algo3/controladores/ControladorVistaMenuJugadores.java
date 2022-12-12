package edu.fiuba.algo3.controladores;

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

    protected ArrayList<String> opcionesInvalidasProtoss;
    protected ArrayList<String> opcionesInvalidasZerg;

    public abstract void establecerPerfil(String perfil, String nombre);

    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    private void instanciarOpcionesInvalidas() {
        // TODO: agregar las opciones invalidas.
        if (this.perfil.equals("protoss")) {
            this.opcionesInvalidasProtoss = new ArrayList<String>();
            this.opcionesInvalidasProtoss.add("String");
            this.opcionesInvalidasProtoss.add("String");
            this.opcionesInvalidasProtoss.add("String");
            this.opcionesInvalidasProtoss.add("String");
        } else {
            this.opcionesInvalidasZerg = new ArrayList<String>();
            this.opcionesInvalidasZerg.add("String");
            this.opcionesInvalidasZerg.add("String");
            this.opcionesInvalidasZerg.add("String");
            this.opcionesInvalidasZerg.add("String");
        }
    }

    protected abstract void establecerNombre(String nombre);

    public void mostrarOpciones(ArrayList<String> opciones){
        instanciarOpcionesInvalidas();

        opciones = eliminarOpcionesInvalidas(opciones);
        int cantidadDeMenus = opciones.toArray().length;

        instanciarAcordeon();

        TitledPane[] titledPane = new TitledPane[cantidadDeMenus];

        for (int i = 0; i < cantidadDeMenus; i++) {
            AnchorPane nuevoAnchorPane = new AnchorPane();
            nuevoAnchorPane.setId("anchorPane_"+i);

            titledPane[i] = new TitledPane(opciones.get(i), nuevoAnchorPane);
            titledPane[i].setId("titlePane_"+i);
        }
        acordeon.getPanes().addAll(titledPane);

        mostrarEnVBox();
    }

    protected abstract void mostrarEnVBox();

    protected ArrayList<String> eliminarOpcionesInvalidas(ArrayList<String> opciones) {

        if (this.opcionesInvalidasProtoss != null) {
            for (String opcionInvalida : this.opcionesInvalidasProtoss) {
                opciones.remove(opcionInvalida);
            }
            return opciones;
        }

        for (String opcionInvalida : this.opcionesInvalidasZerg) {
            opciones.remove(opcionInvalida);
        }
        return opciones;

    }

    protected void instanciarAcordeon() {
        this.acordeon = new Accordion();
        this.acordeon.setId("acordeon");
    }

}

