package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Random;

public class ControladorVistaMapa {
    @FXML
    private BorderPane baseMapa;

    private final Mapa mapa = Mapa.getInstance();
    private final int LONGITUD_FILAS_MAPA = 10; // Alto mapa;
    private final int LONGITUD_COLUMNAS_MAPA = 10;// Ancho mapa
    private GridPane grilla;
    private App app;
    private String[] opcionesRocas = new String[3];
    private Button botonAnterior;

    private ArrayList<Celda> celdasConExtractor = new ArrayList<>();

    private boolean seActualizo = false;

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

    public void establecerApp(App app) { this.app = app; }

    public void mostrarMapa() {

        if (this.grilla == null) {
            inicializarGrilla();
        }

        pedirSprites(true);

        if (this.seActualizo) {
            actualizarMapa();
            this.seActualizo = true;
        }

    }

    public void pedirSprites(boolean primeraVez) {
        for (int fila = 0; fila < LONGITUD_FILAS_MAPA; fila++) {

            for (int columna = 0; columna < LONGITUD_COLUMNAS_MAPA; columna++) {

                Posicion posicion = new Posicion(fila, columna);
                Celda celda = mapa.obtenerCelda(posicion);

                if ((celda.obtenerOcupanteTerrestre()).equals(new Extractor(new Volcan()))) {
                    this.celdasConExtractor.add(celda);
                }

                String spriteTipo = celda.obtenerSpriteTipo();
                if (spriteTipo != null) {
                    agregarSprite(spriteTipo, fila, columna);
                    agregarBoton(fila, columna);
                }

                String spriteRecurso = celda.obtenerSpriteRecurso();
                if (spriteRecurso != null) {
                    agregarSprite(spriteRecurso, fila, columna);
                    agregarBoton(fila, columna);
                }

                String spriteOcupanteTerrestre = celda.obtenerSpriteOcupanteTerrestre();
                if (spriteOcupanteTerrestre != null) {
                    agregarSprite(spriteOcupanteTerrestre, fila, columna);
                    agregarBoton(fila, columna);
                }

                String spriteOcupanteAero = celda.obtenerSpriteOcupanteAereo();
                if (spriteOcupanteAero != null) {
                    agregarSprite(spriteOcupanteAero, fila, columna);
                    agregarBoton(fila, columna);
                }


            }

        }
    }

    public void actualizarMapa(){
        this.grilla.getChildren().clear();
        pedirSprites(false);
    }

    public void agregarSprite(String rutaSprite, int fila, int columna) {

        Image imagen = new Image(getClass().getResourceAsStream(rutaSprite));

        ImageView sprite = new ImageView();
        sprite.setFitWidth(70.0);
        sprite.setFitHeight(70.0);
        sprite.setImage(imagen);

        this.grilla.add(sprite, fila, columna);
    }

    public void agregarBoton(int fila, int columna) {

        BotonCelda botonCelda = new BotonCelda(fila, columna, this);

        this.grilla.add(botonCelda.obtenerBotonNodo(), fila, columna);
    }

    public void gestionarClickEnCelda(int fila, int columna, Button boton) {
        Posicion posicion = new Posicion(fila, columna);
        Celda celda = mapa.obtenerCelda(posicion);

        desactivarBoton(boton);
        marcarSeleccionada(fila, columna);
        app.mostrarMenu(celda.gestionarOpcionesParaJugador(), celda);
    }

    public void marcarSeleccionada(int fila, int columna) {

        this.grilla.add(seleccionada, fila, columna);
    }

    public Celda[] obtenerCeldasConExtractor() {
        ArrayList<Celda> celda = this.celdasConExtractor;
        Celda[] celdas = (Celda[]) celda.toArray();
        return celdas;
    }

    private void desactivarBoton(Button boton) {

        if (this.botonAnterior != null) {
            this.botonAnterior.setDisable(false);
        }
        boton.setDisable(true);
        this.botonAnterior = boton;
    }

}
