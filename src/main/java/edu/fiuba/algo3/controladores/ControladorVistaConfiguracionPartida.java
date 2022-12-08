package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;

import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Comunidad.*;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ControladorVistaConfiguracionPartida {

    @FXML
    private TextField nombreJugadorUno;
    @FXML
    private TextField nombreJugadorDos;
    @FXML
    private CheckBox checkZergJugadorUno;
    @FXML
    private CheckBox checkZergJugadorDos;
    @FXML
    private CheckBox checkProtossJugadorUno;
    @FXML
    private CheckBox checkProtossJugadorDos;
    @FXML
    private Button botonIniciarPartida;

    private Alert warning = new Alert(Alert.AlertType.WARNING);
    private App app;

    private Partida partida;
    private Comunidad[] comunidades = new Comunidad[2];
    private String[] nombreDeJugadores = new String[2];

    public void setApp(App app) {
        this.app = app;
    }

    public void gestionarBotonIniciarPartida() {
        this.botonIniciarPartida.setVisible(false);

        if (!validarInformacionObligatoria()) {
            gestionarPasajeDeDatosAlBackend();
            mostrarVistaJuego();
        } else {
            this.botonIniciarPartida.setVisible(true);
        }
    }

    private boolean validarInformacionObligatoria() {
        boolean fallo = false;

        if ( this.nombreJugadorUno.getLength() == 0 || this.nombreJugadorDos.getLength() == 0 ) {
            warning.setHeaderText(null);
            warning.setTitle("Atencion");
            warning.setContentText("Se debe ingresar al menos un caracter para el nombre de los jugadores.");
            warning.showAndWait();
            fallo = true;
        }

        return fallo;

    }

    public void gestionarPasajeDeDatosAlBackend() {
        this.partida = new Partida();
        this.partida.agregarJugadores(this.nombreDeJugadores, this.comunidades);
    }

    public void gestionarSeleccionDeRaza() {
        try {
            //Jugador uno
            if (!this.checkZergJugadorUno.isSelected() && !this.checkProtossJugadorUno.isSelected()) { // No eligio ninguno se elije por defecto
                this.checkProtossJugadorUno.setVisible(true);
                this.checkZergJugadorUno.setVisible(true);
                this.comunidades[0] = ComunidadZerg.obtenerInstanciaDeClase(); // Por defecto Zerg

            } else if (this.checkZergJugadorUno.isSelected()) { //Elije Zerg
                this.checkProtossJugadorUno.setVisible(false);
                this.comunidades[0] = ComunidadZerg.obtenerInstanciaDeClase();

            } else { //Elije Protoss
                this.checkZergJugadorUno.setVisible(false);
                this.comunidades[0] = ComunidadProtoss.obtenerInstanciaDeClase();

            }
        } catch (RuntimeException e) { System.out.println("Error en obtencion de Comunidad j1"); }

        try {
            //Jugador dos
            if ( !this.checkZergJugadorDos.isSelected() && !this.checkProtossJugadorDos.isSelected() ) { // No eligio ninguno se elije por defecto
                this.checkProtossJugadorDos.setVisible(true);
                this.checkZergJugadorDos.setVisible(true);
                this.comunidades[1] = ComunidadProtoss.obtenerInstanciaDeClase(); // Por defecto Protoss

            } else if (this.checkZergJugadorDos.isSelected()){ //Elije Zerg
                this.checkProtossJugadorDos.setVisible(false);
                this.comunidades[1] = ComunidadZerg.obtenerInstanciaDeClase();

            } else { //Elije Protoss
                this.checkZergJugadorDos.setVisible(false);
                this.comunidades[1] = ComunidadProtoss.obtenerInstanciaDeClase();

            }
        } catch (RuntimeException e) { System.out.println("Error en obtencion de Comunidad j2"); }
    }

    public void mostrarVistaJuego() {
        app.mostrarVistaJuego();
    }

}
