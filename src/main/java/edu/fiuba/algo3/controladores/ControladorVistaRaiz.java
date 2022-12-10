package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class ControladorVistaRaiz {

    @FXML
    private MenuBar barraMenu;
    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void visibilidadDeCambioDePantalla(){
        if ( true ) { // TODO: Si la ventana es x entonces x no se muestra en el menu

        } else {

        }
    }
    
    public void ocultarMenuBar() {
        this.barraMenu.setVisible(false);
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
