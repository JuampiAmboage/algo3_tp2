package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
/*
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
*/
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
    private CheckBox zergJugadorUno;
    @FXML
    private CheckBox zergJugadorDos;
    @FXML
    private CheckBox protossJugadorUno;
    @FXML
    private CheckBox protossJugadorDos;
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
        //Jugador uno
        if ( !this.zergJugadorUno.isSelected() && !this.protossJugadorUno.isSelected() ) { // No eligio ninguno se elije por defecto
            this.protossJugadorUno.setVisible(true);
            this.zergJugadorUno.setVisible(true);
            this.comunidades[0] = ComunidadZerg.obtenerInstanciaDeClase(); // Por defecto Zerg

        } else if (this.zergJugadorUno.isSelected()){ //Elije Zerg
            this.protossJugadorUno.setVisible(false);
            this.comunidades[0] = ComunidadZerg.obtenerInstanciaDeClase();

        } else { //Elije Protoss
            this.zergJugadorUno.setVisible(false);
            this.comunidades[0] = ComunidadProtoss.obtenerInstanciaDeClase();

        }

        //Jugador dos
        if ( !this.zergJugadorDos.isSelected() && !this.protossJugadorDos.isSelected() ) { // No eligio ninguno se elije por defecto
            this.protossJugadorDos.setVisible(true);
            this.zergJugadorDos.setVisible(true);
            this.comunidades[1] = ComunidadProtoss.obtenerInstanciaDeClase(); // Por defecto Protoss

        } else if (this.zergJugadorDos.isSelected()){ //Elije Zerg
            this.protossJugadorDos.setVisible(false);
            this.comunidades[1] = ComunidadZerg.obtenerInstanciaDeClase();

        } else {
            this.zergJugadorDos.setVisible(false);
            this.comunidades[1] = ComunidadProtoss.obtenerInstanciaDeClase();

        }
    }

    public void mostrarVistaJuego() {
        app.mostrarVistaJuego();
    }

}
