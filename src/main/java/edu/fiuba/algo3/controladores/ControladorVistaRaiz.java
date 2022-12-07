package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class ControladorVistaRaiz {
    //@FXML
    //private MenuBar barraMenu;

    @FXML
    private MenuItem botonPantallaCompleta;
    @FXML
    private MenuItem botonPantallaReducida;

    private App app;

    public void construirDatosIniciales() {
        this.botonPantallaCompleta.setVisible(false);
        this.botonPantallaReducida.setVisible(true);
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void gestionarPantallaCompleta() {
        app.pantallaCompleta();
        visibilidadDeBotonesPantalla();
    }
    public void gestionarPantallaReducida() {
        app.pantallaReducida();
        visibilidadDeBotonesPantalla();
    }
    public void visibilidadDeBotonesPantalla(){
        if ( app.estaEnPantallaCompleta() ) {
            this.botonPantallaCompleta.setVisible(false);
            this.botonPantallaReducida.setVisible(true);
        } else {
            this.botonPantallaCompleta.setVisible(true);
            this.botonPantallaReducida.setVisible(false);
        }
    }

    public void gestionarBotonSalir() {
        app.salir();
    }
    public void gestionarCambioAVistaInicio() {
        app.mostrarVistaInicio();
    }
    public void gestionarCambioAVistaConfiguracionPartida() {
        app.mostrarVistaConfiguracionPartida();
    }
}
