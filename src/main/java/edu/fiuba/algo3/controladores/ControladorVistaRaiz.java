package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class ControladorVistaRaiz {

    @FXML
    private MenuBar barraMenu;
    @FXML
    private BorderPane borderPane;
    private App app;
    private Insets insets;

    public void setApp(App app) {
        this.app = app;
    }
    
    public void ocultarMenuBar() {
        this.barraMenu.setVisible(false);

        this.insets = new Insets(-25,0,0,0);
        this.borderPane.setPadding(insets);

    }
    public void mostrarMenuBar() {
        this.barraMenu.setVisible(true);

        this.insets = new Insets(0, 0, 0, 0);
        this.borderPane.setPadding(insets);
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
