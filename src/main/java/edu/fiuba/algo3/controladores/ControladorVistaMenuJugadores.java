package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public abstract class ControladorVistaMenuJugadores {

    protected String perfil;
    protected String nombre;

    protected String almacenDeGas;
    protected String almacenDeMineral;

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
    public void mostrarOpciones(ArrayList<OpcionElegible> opciones, Celda celda){
        limpiarMenu();

        opciones = eliminarOpcionesInvalidas(opciones);


        if (opciones.toArray().length != 0) {
            TitledPane[] titledPane = new TitledPane[opciones.toArray().length];

            instanciarAcordeon();

            for (int i = 0; i < opciones.toArray().length; i++) {
                OpcionElegible opcion = opciones.get(i);

                BorderPane nuevoBorderPane = new BorderPane();
                VBox vBox = new VBox();
                vBox.setId("vBoxMenuInterno");

                ArrayList<BotonMenuJugador> botones = obtenerBoton(opcion, celda);
                for (BotonMenuJugador boton : botones) {
                    vBox.getChildren().add(boton.obtenerBotonNodo());
                }

                nuevoBorderPane.setCenter(vBox);


                titledPane[i] = new TitledPane((opciones.get(i)).obtenerTitulo(), nuevoBorderPane);
                titledPane[i].setAnimated(true);
            }
            acordeon.getPanes().addAll(titledPane);

            mostrarEnVBox();
        }
    }
    public abstract void limpiarMenu();
    protected ArrayList<OpcionElegible> eliminarOpcionesInvalidas(ArrayList<OpcionElegible> opciones) {

        int cantidad = opciones.toArray().length;
        int iterador = 0;

        for (int i = 0; i < cantidad; i++) {
            OpcionElegible opcion = opciones.get(iterador);
            String perteneceA = opcion.obtenerPertenencia();

            if (perteneceA != null) {
                if (!perteneceA.equals(this.perfil)) {
                    opciones.remove(opcion);
                }else{
                    iterador++;
                }
            }else{
                iterador++;
            }
        }

        return opciones;

    }
    protected void instanciarAcordeon() {
        this.acordeon = new Accordion();
        this.acordeon.setId("acordeon");

    }
    protected ArrayList<BotonMenuJugador> obtenerBoton(OpcionElegible opcion, Celda celda) {
        ArrayList<BotonMenuJugador> botones = new ArrayList<>();
        for (int i = 0; i < opcion.cantidadDeOpcionesInternas(); i++) {
            BotonMenuJugador boton = new BotonMenuJugador(opcion, this, celda, i);
            botones.add(boton);
        }
        return botones;
    }
    protected abstract void mostrarEnVBox();

    public void actualizarMapa() { this.app.actualizarMapa(); }

    public ArrayList<Celda> obtenerCeldasConExtractor() { return this.app.obtenerCeldasConExtractor(); }
    public ArrayList<Celda> obtenerCeldasConTropas() { return this.app.obtenerCeldasConTropas(); }

    public abstract void activar();
    public abstract void desactivar();
    public abstract void indicadorDeTurnoActivo();

    public abstract void establecerAlmacenamiento(int[] almacenamiento);

    public abstract void actualizarAlmacenamiento();

    protected void mostrarTurno() {
        app.mostrarTurno("Es el turno de: " + this.nombre);
    }
}

