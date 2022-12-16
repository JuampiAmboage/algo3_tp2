package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.AsignarTrabajoEnExtractor;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonMenuJugador {

    public Button botonNodo;
    private OpcionElegible opcion;
    private ControladorVistaMenuJugadores controlador;

    public BotonMenuJugador(OpcionElegible opcion, ControladorVistaMenuJugadores controlador, Celda celda, int index) {
        this.opcion = opcion;

        this.controlador = controlador;

        this.botonNodo = new Button();
        this.botonNodo.setText(opcion.obtenerTextoBoton(index));

        String opcionElejida = opcion.obtenerTextoBoton(index);

        this.botonNodo.setOnAction(e->gestionarClick(celda, opcionElejida));
    }

    public Button obtenerBotonNodo() { return this.botonNodo; }
    private void gestionarClick(Celda celda, String opcionElejida) {

        if (this.opcion.equals(new AsignarTrabajoEnExtractor(""))) {
            Celda[] celdas = this.controlador.obtenerCeldasConExtractor();
            this.opcion.estblecerCeldasConExtractor(celdas);
        }

        this.opcion.gestionarClick(celda, opcionElejida);
        this.controlador.actualizarMapa();
    }
}

