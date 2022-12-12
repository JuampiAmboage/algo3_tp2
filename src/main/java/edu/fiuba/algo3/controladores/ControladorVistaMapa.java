package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Random;

public class ControladorVistaMapa {

    private final Mapa mapa = Mapa.getInstance();
    private final int LONGITUD_FILAS_MAPA = 10; // Alto mapa;
    private final int LONGITUD_COLUMNAS_MAPA = 10;// Ancho mapa
    private GridPane grilla;

    private App app;

    private final String rutaRocas = "/sprites/celdas/decoracion/";

    private String[] opcionesRocas = new String[3];

    @FXML
    private Button botonCelda;
    @FXML
    private BorderPane baseMapa;

    private void inicializarSpriteRocas() {
        this.opcionesRocas[0] = "rocas00.png";
        this.opcionesRocas[1] = "rocas01.png";
        this.opcionesRocas[2] = "rocas02.png";
    }

    private void inicializarGrilla() {
        this.grilla = new GridPane();
        this.grilla.setGridLinesVisible(true);

        this.grilla.setMaxSize(700.0, 700.0);
        this.grilla.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        this.grilla.setPrefSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        this.grilla.setAlignment(Pos.CENTER);
        this.grilla.setId("grilla");

        this.baseMapa.setCenter(grilla);
    }

    public void mostrarMapa(App app) {

        if (this.grilla == null) {
            inicializarGrilla();
        }

        this.app = app;

        for (int fila = 0; fila < LONGITUD_FILAS_MAPA; fila++) {

            for (int columna = 0; columna < LONGITUD_COLUMNAS_MAPA; columna++) {

                Posicion posicion = new Posicion(fila, columna);
                Celda celda = mapa.obtenerCelda(posicion);

                String rutaSprite = celda.obtenerSprite();
                String rutaSpriteFinal = rutaSprite;

                inicializarSpriteRocas();
                agregarSprite(rutaSpriteFinal, fila, columna);
                agregarBoton(fila,columna);

            }

        }

    }

    public void agregarSprite(String rutaSprite, int fila, int columna) {

        Image imagen = new Image(getClass().getResourceAsStream(rutaSprite));

        ImageView sprite = new ImageView();
        sprite.setFitWidth(70.0);
        sprite.setFitHeight(70.0);
        sprite.setImage(imagen);

        this.grilla.add(sprite, fila, columna);

        if (agregarRocas()) {
            this.grilla.add(obtenerSpriteRoca(), fila, columna);
        }

    }

    public ImageView obtenerSpriteRoca() {

        String rutaFinal = elejirRutaRandom();

        Image imagen = new Image(getClass().getResourceAsStream(rutaFinal));

        ImageView sprite = new ImageView();
        sprite.setFitWidth(70.0);
        sprite.setFitHeight(70.0);
        sprite.setImage(imagen);

        return sprite;
    }

    public String elejirRutaRandom() {
        Random random = new Random();
        int maximo = 3;
        int eleccionRandom = random.nextInt(maximo);

        return (this.rutaRocas + this.opcionesRocas[eleccionRandom]);

    }

    public boolean agregarRocas() {

        Random random = new Random();
        int maximo = 3;
        int eleccionRandom = random.nextInt(maximo);

        if (eleccionRandom == 1) {
            return true;
        }
        return false;
    }

    public void agregarBoton(int fila, int columna) {

        Boton boton = new Boton(fila, columna, this);

        this.grilla.add(boton.obtenerBoton(), fila, columna);
    }

    public void gestionarClickEnCelda(int fila, int columna) {
        Posicion posicion = new Posicion(fila, columna);
        Celda celda = mapa.obtenerCelda(posicion);

        app.mostrarMenu(celda.gestionarOpcionesParaJugador());
    }

}
