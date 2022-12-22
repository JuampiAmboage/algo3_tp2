package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.AtaqueTropaTerrestre;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.scene.control.Button;

public class BotonAtaque {

    private Celda celda;
    private ControladorVistaMapa controladorVistaMapa;
    private Button botonNodo;
    private OpcionElegible opcion;

    public BotonAtaque(Celda celda, ControladorVistaMapa controladorVistaMapa, OpcionElegible opcion) {
        this.celda = celda;
        this.controladorVistaMapa = controladorVistaMapa;
        this.opcion = opcion;

        this.botonNodo = new Button();
        this.botonNodo.setPrefSize(70.0, 70.0);
        this.botonNodo.setStyle("-fx-background-color: #5000009E");
        this.botonNodo.setOnAction(e->gestionarClickEnCelda());
    }

    public Button obtenerBotonNodo() { return this.botonNodo; }
    private void gestionarClickEnCelda() {
        this.opcion.atacar(this.celda);
    }

}
