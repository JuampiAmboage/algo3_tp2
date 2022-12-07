package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
import edu.fiuba.algo3.modelo.Partida.Partida;

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
    private Edificio[] edificios = new Edificio[2];
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
        this.partida.agregarJugadores(this.nombreDeJugadores, this.edificios);
    }

    public void gestionarSeleccionDeRaza() {
        //Jugador uno
        if ( !this.zergJugadorUno.isSelected() && !this.protossJugadorUno.isSelected() ) { // No eligio ninguno se elije por defecto
            this.protossJugadorUno.setVisible(true);
            this.zergJugadorUno.setVisible(true);
            this.edificios[0] = new Criadero(); // Por defecto Zerg

        } else if (this.zergJugadorUno.isSelected()){ //Elije Zerg
            this.protossJugadorUno.setVisible(false);
            this.edificios[0] = new Criadero();

        } else { //Elije Protoss
            this.zergJugadorUno.setVisible(false);
            this.edificios[0] = new Pilon();

        }

        //Jugador dos
        if ( !this.zergJugadorDos.isSelected() && !this.protossJugadorDos.isSelected() ) { // No eligio ninguno se elije por defecto
            this.protossJugadorDos.setVisible(true);
            this.zergJugadorDos.setVisible(true);
            this.edificios[1] = new Pilon(); // Por defecto Protoss

        } else if (this.zergJugadorDos.isSelected()){ //Elije Zerg
            this.protossJugadorDos.setVisible(false);
            this.edificios[1] = new Criadero();

        } else {
            this.zergJugadorDos.setVisible(false);
            this.edificios[1] = new Pilon();

        }
    }

    public void mostrarVistaJuego() {
        app.mostrarVistaJuego();
    }

}
