package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.AtaqueTropaTerrestre;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import javafx.scene.control.Button;

import java.util.Objects;

public class BotonAtaque {

    private Celda celdaAtacada;
    private Celda celdaAtacante;
    private ControladorVistaMenuJugadores controladorJugador;

    private Button botonNodo;
    private OpcionElegible opcion;

    public BotonAtaque(Celda celdaAtacada, OpcionElegible opcion, Celda celdaAtacante, ControladorVistaMenuJugadores controladorJugador, String opcionElejida) {
        this.celdaAtacada = celdaAtacada;
        this.celdaAtacante = celdaAtacante;

        this.controladorJugador = controladorJugador;

        this.opcion = opcion;

        this.botonNodo = new Button();
        this.botonNodo.setId("botonAtaque");

        this.botonNodo.setPrefSize(70.0, 70.0);

        this.botonNodo.setOnAction(e->gestionarClickEnCelda(opcionElejida));
    }

    public Button obtenerBotonNodo() { return this.botonNodo; }

    private void gestionarClickEnCelda(String opcionElejida) {
        Tropa unidadQueAtaca;
        Unidad unidadAtacada;

        if (this.opcion instanceof AtaqueTropaTerrestre) {
            unidadQueAtaca = (Tropa) this.celdaAtacante.obtenerOcupanteTerrestre();
        } else {
            unidadQueAtaca = this.celdaAtacante.obtenerOcupanteAereo();
        }

        if (opcionElejida.equals(opcion.obtenerTextoBoton(0))) {
            unidadAtacada = this.celdaAtacada.obtenerOcupanteAereo();
            unidadQueAtaca.atacarAire((TropaAerea) unidadAtacada);
        } else{
            unidadAtacada = this.celdaAtacada.obtenerOcupanteTerrestre();
            unidadQueAtaca.atacarTierra(unidadAtacada);
        }

        this.controladorJugador.actualizarMapa();
    }

}
