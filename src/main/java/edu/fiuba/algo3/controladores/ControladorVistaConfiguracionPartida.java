package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;

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
    private Alert error = new Alert(Alert.AlertType.ERROR);
    private App app;

    private String[] raza = new String[2];

    public void setApp(App app) {
        this.app = app;
    }

    public void gestionarBotonIniciarPartida() {
        this.botonIniciarPartida.setVisible(false);

        if (!validarInformacionObligatoria()) {
            // TODO: incializar la ventana de juego.
            gestionarPasajeDeDatosAlBackend();
        }

        this.botonIniciarPartida.setVisible(true);

    }

    public void gestionarSeleccionDeRaza() {
        //Jugador uno
        if ( !this.zergJugadorUno.isSelected() && !this.protossJugadorUno.isSelected() ) { //No eligio ninguno
            this.protossJugadorUno.setVisible(true);
            this.zergJugadorUno.setVisible(true);
            this.raza[0] = "Zerg"; //Se asigan una comunidad Zerg por defecto

        } else if (this.zergJugadorUno.isSelected()){ //Elije Zerg
            this.protossJugadorUno.setVisible(false);
            this.raza[0] = "Zerg"; //Por ahora String[] despues se va a cambiar a Raza[] (una instancia de un raza)

        } else { //Elije Protoss
            this.zergJugadorUno.setVisible(false);
            this.raza[1] = "Protoss";

        }

        //Jugador dos
        if ( !this.zergJugadorDos.isSelected() && !this.protossJugadorDos.isSelected() ) { //No elije nada
            this.protossJugadorDos.setVisible(true);
            this.zergJugadorDos.setVisible(true);
            this.raza[1] = "Protoss"; //Se asigan una comunidad Protoss por defecto

        } else if (this.zergJugadorDos.isSelected()){ //Elije Zerg
            this.protossJugadorDos.setVisible(false);
            this.raza[1] = "Zerg";

        } else {
            this.zergJugadorDos.setVisible(false);
            this.raza[1] = "Protoss";

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
        // TODO: Gestionar el pasaje de datos al "backend".
    }

}
