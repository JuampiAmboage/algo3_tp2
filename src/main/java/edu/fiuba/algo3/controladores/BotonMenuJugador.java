package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.AsignarTrabajoEnExtractor;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import javafx.scene.control.Button;

import java.io.PipedOutputStream;

public class BotonMenuJugador {

    public Button botonNodo;
    private OpcionElegible opcion;
    private ControladorVistaMenuJugadores controlador;

    public BotonMenuJugador(OpcionElegible opcion, ControladorVistaMenuJugadores controlador, Celda celda) {
        this.opcion = opcion;

        this.controlador = controlador;

        this.botonNodo = new Button();
        this.botonNodo.setText(opcion.obtenerTextoBoton());

        this.botonNodo.setOnAction(e->gestionarClick(celda));
    }

    public Button obtenerBotonNodo() { return this.botonNodo; }
    private void gestionarClick(Celda celda) {
        if (this.opcion.equals(new AsignarTrabajoEnExtractor(""))) {
            Celda[] celdas = this.controlador.obtenerCeldasConExtractor();
            this.opcion.estblecerCeldasConExtractor(celdas);
        }

        this.opcion.gestionarClick(celda);
        this.controlador.actualizarMapa();
    }
}

