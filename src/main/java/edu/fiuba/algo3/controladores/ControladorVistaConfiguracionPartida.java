package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;

import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Razas.Unidad;

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
        if ( !this.zergJugadorUno.isSelected() && !this.protossJugadorUno.isSelected() ) { //No eligio ninguno
            this.protossJugadorUno.setVisible(true);
            this.zergJugadorUno.setVisible(true);
            this.unidades[0] = new ; //Se asigan una comunidad Zerg por defecto

        } else if (this.zergJugadorUno.isSelected()){ //Elije Zerg
            this.protossJugadorUno.setVisible(false);
            this.unidades[0] = new ; // Se asigna una comunidad Zerg

        } else { //Elije Protoss
            this.zergJugadorUno.setVisible(false);
            this.unidades[0] = new ;

        }

        //Jugador dos
        if ( !this.zergJugadorDos.isSelected() && !this.protossJugadorDos.isSelected() ) { //No elije nada
            this.protossJugadorDos.setVisible(true);
            this.zergJugadorDos.setVisible(true);
            this.unidades[1] = new ; //Se asigan una comunidad Protoss por defecto

        } else if (this.zergJugadorDos.isSelected()){ //Elije Zerg
            this.protossJugadorDos.setVisible(false);
            this.unidades[1] = new ;

        } else {
            this.zergJugadorDos.setVisible(false);
            this.unidades[1] = new ;

        }
    }

    public void mostrarVistaJuego() {
        app.mostrarVistaJuego();
    }

}
