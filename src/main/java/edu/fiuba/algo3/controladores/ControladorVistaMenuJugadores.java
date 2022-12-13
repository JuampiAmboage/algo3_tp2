package edu.fiuba.algo3.controladores;

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

    protected abstract void establecerNombre(String nombre);
    public abstract void establecerPerfil(String perfil, String nombre);
    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    protected ArrayList<OpcionElegible> eliminarOpcionesInvalidas(ArrayList<OpcionElegible> opciones) {
        // TODO: Chequear que funcione lo de != null.
        for (OpcionElegible opcion : opciones) {
            String perteneceA = opcion.obtenerPertenencia();

            if (!perteneceA.equals(this.perfil)) {
                if (perteneceA != null) {
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
            nuevoBorderPane.setLeft(imagen);

            ArrayList<Button> botones = obtenerBotones(opcion);
            for (Button boton : botones) {
                nuevoBorderPane.setCenter(boton);
            }

            titledPane[i] = new TitledPane((opciones.get(i)).obtenerTitulo(), nuevoBorderPane);
            titledPane[i].setId("titlePane_"+i);
        }
        acordeon.getPanes().addAll(titledPane);

        mostrarEnVBox();
    }

    public ImageView insertarImagen(OpcionElegible opcion){

        String rutaImagen = opcion.obtenerImagen();

        Image imagen = new Image(getClass().getResourceAsStream(rutaImagen));

        ImageView visulizadorDeImagen = new ImageView();
        visulizadorDeImagen.setFitWidth(100.0);
        visulizadorDeImagen.setFitHeight(100.0);
        visulizadorDeImagen.setImage(imagen);

        return visulizadorDeImagen;
    }

    public ArrayList<Button> obtenerBotones(OpcionElegible opcion) {
        ArrayList<Button> botones = new ArrayList<>();
        String[] textoBotones = opcion.obtenerBotones();

        for (String textoBoton : textoBotones) {
            Button boton = new Button();
            boton.setText(textoBoton);

            botones.add(boton);
        }

        return botones;
    }
    protected void instanciarAcordeon() {
        this.acordeon = new Accordion();
        this.acordeon.setId("acordeon");
    }

    protected abstract void limpiarMenu();
    protected abstract void mostrarEnVBox();

    protected void gestionarPasarTurno() {}
}

