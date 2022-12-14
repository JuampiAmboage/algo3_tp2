package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
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

    // PERFIL
    public abstract void establecerPerfil(String perfil, String nombre, App app);
    protected abstract void establecerNombre(String nombre);
    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    // MENU : Instancia de desplegables y botones
    public void mostrarOpciones(ArrayList<OpcionElegible> opciones, Celda celda){
        limpiarMenu();

        opciones = eliminarOpcionesInvalidas(opciones);

        int cantidadDeMenus = opciones.toArray().length;
        TitledPane[] titledPane = new TitledPane[cantidadDeMenus];

        instanciarAcordeon();

        for (int i = 0; i < cantidadDeMenus; i++) {
            OpcionElegible opcion = opciones.get(i);

            BorderPane nuevoBorderPane = new BorderPane();
            //nuevoBorderPane.setId("borderPane_"+i);

            ImageView imagen = insertarImagen(opcion);
            if (imagen != null) { nuevoBorderPane.setLeft(imagen); }

            BotonMenuJugador boton = obtenerBoton(opcion, celda, i);
            nuevoBorderPane.setCenter(boton.obtenerBotonNodo());


            titledPane[i] = new TitledPane((opciones.get(i)).obtenerTitulo(), nuevoBorderPane);
            //titledPane[i].setId("titlePane_"+i);
        }
        acordeon.getPanes().addAll(titledPane);

        mostrarEnVBox();
    }
    public abstract void limpiarMenu();
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
    protected void instanciarAcordeon() {
        this.acordeon = new Accordion();
        this.acordeon.setId("acordeon");
    }
    protected ImageView insertarImagen(OpcionElegible opcion){

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
    protected BotonMenuJugador obtenerBoton(OpcionElegible opcion, Celda celda, int index) {
        BotonMenuJugador boton = new BotonMenuJugador(opcion, this, celda, index);

        return boton;
    }
    protected abstract void mostrarEnVBox();

    public void actualizarMapa() { this.app.actualizarMapa(); }

    public Celda[] obtenerCeldasConExtractor() {
        return this.app.obtenerCeldasConExtractor();
    }

}

