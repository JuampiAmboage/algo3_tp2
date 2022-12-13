package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.scene.control.Button;

public class BotonMenuJugador {

    public Button botonNodo;
    private OpcionElegible opcion;

    public BotonMenuJugador(String texto, OpcionElegible opcion) {
        this.opcion = opcion;

        this.botonNodo = new Button();
        this.botonNodo.setText(texto);

        this.botonNodo.setOnAction(e->gestionarClick());
    }

    public Button obtenerBotonNodo() { return this.botonNodo; }
    private void gestionarClick() { this.opcion.gestionarClick(); }
}

