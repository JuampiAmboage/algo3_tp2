package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.scene.control.Button;

public class BotonMenuJugador {

    public Button botonNodo;
    private OpcionElegible opcion;

    private ControladorVistaMenuJugadores controlador;

    public BotonMenuJugador(String texto, OpcionElegible opcion, ControladorVistaMenuJugadores controlador) {
        this.opcion = opcion;

        this.controlador = controlador;

        this.botonNodo = new Button();
        this.botonNodo.setText(texto);

        this.botonNodo.setOnAction(e->gestionarClick());
    }

    public Button obtenerBotonNodo() { return this.botonNodo; }
    private void gestionarClick() {
        this.opcion.gestionarClick();
        this.controlador.actualizarMapa();
    }
}

