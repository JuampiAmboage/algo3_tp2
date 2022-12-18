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
    private String[] perfiles = new String[2];

    private String perfilZerg = "zerg";
    private String perfilProtoss = "protoss";

    public void setApp(App app) {
        this.app = app;
    }

    public void gestionarBotonIniciarPartida() {
        this.botonIniciarPartida.setVisible(false);

        if (validarInformacionObligatoria()) {
            gestionarPasajeDeDatosAlBackend();
            mostrarVistaJuego(this.perfiles);
        } else {
            this.botonIniciarPartida.setVisible(true);
        }
    }

    private boolean validarInformacionObligatoria() {

        if ( (this.nombreJugadorUno.getLength() == 0) || (this.nombreJugadorDos.getLength() == 0) ) {
            warning.setHeaderText(null);
            warning.setTitle("Atencion");
            warning.setContentText("Se debe ingresar al menos un caracter para el nombre de los jugadores.");
            warning.showAndWait();
            return false;
        }

        if (!this.checkZergJugadorUno.isSelected() && !this.checkProtossJugadorUno.isSelected() ||
                !this.checkZergJugadorDos.isSelected() && !this.checkProtossJugadorDos.isSelected()) {
            warning.setHeaderText(null);
            warning.setTitle("Atencion");
            warning.setContentText("Se debe seleccionar una raza.");
            warning.showAndWait();
            return false;
        }


        this.nombreDeJugadores[0] = this.nombreJugadorUno.getText();
        this.nombreDeJugadores[1] = this.nombreJugadorDos.getText();

        gestionarSeleccionDeRaza();

        return true;

    }

    public void gestionarPasajeDeDatosAlBackend() {
        this.partida = new Partida(this.nombreDeJugadores, this.comunidades);
        this.app.establecerPartida(this.partida);
    }

    public void gestionarSeleccionDeRaza() {
        //Jugador uno
        if (this.checkZergJugadorUno.isSelected()) { //Elije Zerg

            this.checkProtossJugadorUno.setVisible(false);

            // Actualizo opciones J2
            this.checkZergJugadorDos.setVisible(false);
            this.checkProtossJugadorDos.setVisible(true);

            this.comunidades[0] = ComunidadZerg.obtenerInstanciaDeClase();
            this.perfiles[0] = this.perfilZerg;

        } else if (this.checkProtossJugadorUno.isSelected()){ //Elije Protoss

            this.checkZergJugadorUno.setVisible(false);

            // Actualizo opciones J2
            this.checkZergJugadorDos.setVisible(true);
            this.checkProtossJugadorDos.setVisible(false);

            this.comunidades[0] = ComunidadProtoss.obtenerInstanciaDeClase();
            this.perfiles[0] = this.perfilProtoss;
        }

        //Jugador dos
        if (this.checkZergJugadorDos.isSelected()){ //Elije Zerg

            this.checkProtossJugadorDos.setVisible(false);

            // Actualizo opciones J1
            this.checkProtossJugadorUno.setVisible(true);
            this.checkZergJugadorUno.setVisible(false);

            this.comunidades[1] = ComunidadZerg.obtenerInstanciaDeClase();

            this.perfiles[1] = this.perfilZerg;

        } else if (this.checkProtossJugadorDos.isSelected()){ //Elije Protoss

            this.checkZergJugadorDos.setVisible(false);

            // Actualizo opciones J1
            this.checkProtossJugadorUno.setVisible(false);
            this.checkZergJugadorUno.setVisible(true);

            this.comunidades[1] = ComunidadProtoss.obtenerInstanciaDeClase();
            this.perfiles[1] = this.perfilProtoss;
        }

        if (!this.checkZergJugadorUno.isSelected() && !this.checkProtossJugadorUno.isSelected() ||
                !this.checkZergJugadorDos.isSelected() && !this.checkProtossJugadorDos.isSelected()) {

            this.checkProtossJugadorUno.setVisible(true);
            this.checkZergJugadorUno.setVisible(true);

            this.checkProtossJugadorUno.setVisible(true);
            this.checkZergJugadorUno.setVisible(true);
        }
    }

    public void mostrarVistaJuego(String[] perfiles) {
        app.mostrarVistaJuego(perfiles, this.nombreDeJugadores);
    }

}
