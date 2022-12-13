package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;


public abstract class ControladorVistaMenuJugadores {
    protected String perfil;
    protected String nombre;
    protected Accordion acordeon;
    protected App app;

    protected abstract void establecerNombre(String nombre);
    public abstract void establecerPerfil(String perfil, String nombre, App app);
    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    protected ArrayList<OpcionElegible> eliminarOpcionesInvalidas(ArrayList<OpcionElegible> opciones) {
        for (OpcionElegible opcion : opciones) {
            String perteneceA = opcion.obtenerPertenencia();

            if (perteneceA != null) {
                if (!perteneceA.equals(this.perfil)) {
                    opciones.remove(opcion);
                }
            }
       }
        return opciones;

    }

    public void mostrarOpciones(ArrayList<OpcionElegible> opciones){
        limpiarMenu();

        opciones = eliminarOpcionesInvalidas(opciones);

        int cantidadDeMenus = opciones.toArray().length;
        TitledPane[] titledPane = new TitledPane[cantidadDeMenus];

        instanciarAcordeon();

        for (int i = 0; i < cantidadDeMenus; i++) {
            OpcionElegible opcion = opciones.get(i);

            BorderPane nuevoBorderPane = new BorderPane();
            nuevoBorderPane.setId("borderPane_"+i);

            ImageView imagen = insertarImagen(opcion);
            if (imagen != null) { nuevoBorderPane.setLeft(imagen); }

            BotonMenuJugador boton = obtenerBoton(opcion);
            nuevoBorderPane.setCenter(boton.obtenerBotonNodo());


            titledPane[i] = new TitledPane((opciones.get(i)).obtenerTitulo(), nuevoBorderPane);
            titledPane[i].setId("titlePane_"+i);
        }
        acordeon.getPanes().addAll(titledPane);

        mostrarEnVBox();
    }

    public ImageView insertarImagen(OpcionElegible opcion){

        String rutaImagen = opcion.obtenerImagen();

        if (rutaImagen != null) {
            Image imagen = new Image(getClass().getResourceAsStream(rutaImagen));

            ImageView visulizadorDeImagen = new ImageView();
            visulizadorDeImagen.setFitWidth(100.0);
            visulizadorDeImagen.setFitHeight(100.0);
            visulizadorDeImagen.setImage(imagen);

            return visulizadorDeImagen;
        }
        return null;
    }

    public BotonMenuJugador obtenerBoton(OpcionElegible opcion) {
        String textoBoton = opcion.obtenerBoton();

        BotonMenuJugador boton = new BotonMenuJugador(textoBoton, opcion);

        return boton;
    }
    protected void instanciarAcordeon() {
        this.acordeon = new Accordion();
        this.acordeon.setId("acordeon");
    }

    protected abstract void limpiarMenu();
    protected abstract void mostrarEnVBox();
}

