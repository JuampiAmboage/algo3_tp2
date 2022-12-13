package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Random;

public class ControladorVistaMapa {
    @FXML
    private BorderPane baseMapa;

    private final Mapa mapa = Mapa.getInstance();
    private final int LONGITUD_FILAS_MAPA = 10; // Alto mapa;
    private final int LONGITUD_COLUMNAS_MAPA = 10;// Ancho mapa
    private GridPane grilla;
    private App app;
    private final String rutaRocas = "/sprites/celdas/decoracion/";
    private String[] opcionesRocas = new String[3];
    private Button botonAnterior;

    private boolean seActualizo = false;
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
        inicializarSpriteRocas();

        this.app = app;

        for (int fila = 0; fila < LONGITUD_FILAS_MAPA; fila++) {

            for (int columna = 0; columna < LONGITUD_COLUMNAS_MAPA; columna++) {

                Posicion posicion = new Posicion(fila, columna);
                Celda celda = mapa.obtenerCelda(posicion);

                String spriteTipo = celda.obtenerSpriteTipo();
                if ( spriteTipo != null) {
                    agregarSprite(spriteTipo, fila, columna);
                    agregarBoton(fila,columna);

                }

                if (agregarRocas()) {

                    String spriteRocaNueva = obtenerSpriteRoca();
                    if (spriteRocaNueva != null) { agregarSprite(spriteRocaNueva, fila, columna); }

                }

                String spriteRecurso = celda.obtenerSpriteRecurso();
                if ( spriteRecurso != null) {

                    agregarSprite(spriteRecurso, fila, columna);
                    agregarBoton(fila,columna);

                }

                String spriteOcupanteTerrestre = celda.obtenerSpriteOcupanteTerrestre();
                if ( spriteOcupanteTerrestre != null) {

                    agregarSprite(spriteOcupanteTerrestre, fila, columna);
                    agregarBoton(fila,columna);

                }

                String spriteOcupanteAero = celda.obtenerSpriteOcupanteAereo();
                if ( spriteOcupanteAero != null) {

                    agregarSprite(spriteOcupanteAero, fila, columna);
                    agregarBoton(fila,columna);

                }


            }

        }

        if (this.seActualizo) {
            mostrarMapa(this.app);
            this.seActualizo = true;
        }

    }

    public void agregarSprite(String rutaSprite, int fila, int columna) {

        Image imagen = new Image(getClass().getResourceAsStream(rutaSprite));

        ImageView sprite = new ImageView();
        sprite.setFitWidth(70.0);
        sprite.setFitHeight(70.0);
        sprite.setImage(imagen);

        this.grilla.add(sprite, fila, columna);
    }

    public String obtenerSpriteRoca() { return elejirRutaRandom(); }

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

        BotonCelda botonCelda = new BotonCelda(fila, columna, this);

        this.grilla.add(botonCelda.obtenerBoton(), fila, columna);
    }

    public void gestionarClickEnCelda(int fila, int columna, Button boton) {
        Posicion posicion = new Posicion(fila, columna);
        Celda celda = mapa.obtenerCelda(posicion);

        desactivarBoton(boton);

        app.mostrarMenu(celda.gestionarOpcionesParaJugador());
    }

    private void desactivarBoton(Button boton) {

        if (this.botonAnterior != null) {
            this.botonAnterior.setDisable(false);
        }
        boton.setDisable(true);
        this.botonAnterior = boton;
    }

}
