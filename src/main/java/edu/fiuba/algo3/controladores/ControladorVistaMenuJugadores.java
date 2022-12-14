package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;


public abstract class ControladorVistaMenuJugadores {
    protected String perfil;
    protected String nombre;
    protected boolean activo;

    protected Accordion acordeon;
    protected App app;

    // PERFIL
    public abstract void establecerPerfil(String perfil, String nombre, App app);
    protected abstract void establecerNombre(String nombre);
    protected Image establecerImagen() {
        return new Image(getClass().getResourceAsStream("/sprites/perfiles/"+this.perfil+".png"));
    }

    // MENU : Instancia de desplegables y botones
    public void mostrarOpciones(ArrayList<OpcionElegible> opciones){
        limpiarMenu();

        opciones = eliminarOpcionesInvalidas(opciones);

        int cantidadDeMenus = opciones.toArray().length;

        // TODO: Agregar una condicion de corte si no hay opciones

        TitledPane[] titledPane = new TitledPane[cantidadDeMenus];

        instanciarAcordeon();

        for (int i = 0; i < cantidadDeMenus; i++) {
            OpcionElegible opcion = opciones.get(i);

            BorderPane nuevoBorderPane = new BorderPane();

            ImageView imagen = insertarImagen(opcion);
            if (imagen != null) { nuevoBorderPane.setLeft(imagen); }

            BotonMenuJugador boton = obtenerBoton(opcion);
            nuevoBorderPane.setCenter(boton.obtenerBotonNodo());


            titledPane[i] = new TitledPane((opciones.get(i)).obtenerTitulo(), nuevoBorderPane);
            titledPane[i].setAnimated(true);
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
    protected BotonMenuJugador obtenerBoton(OpcionElegible opcion) {
        String textoBoton = opcion.obtenerBoton();

        BotonMenuJugador boton = new BotonMenuJugador(textoBoton, opcion, this);

        return boton;
    }
    protected abstract void mostrarEnVBox();

    public void actualizarMapa() { this.app.actualizarMapa(); }

    public abstract void activar();
    public abstract void desactivar();
    public abstract void indicadorDeTurnoActivo();
}

