package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;

public class ControladorVistaMapa {

    private final Mapa mapa = Mapa.getInstance();
    private final String RUTA_A_SPRITES = "/sprites";
    private final int LONGITUD_FILAS_MAPA = 10; // Alto mapa;
    private final int LONGITUD_COLUMNAS_MAPA = 10;// Ancho mapa
    private GridPane grilla;

    @FXML
    private BorderPane baseMapa;

    private void inicializarGrilla() {
        this.grilla = new GridPane();
        this.grilla.setGridLinesVisible(true);

        this.grilla.setMaxSize(700.0, 700.0);
        this.grilla.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        this.grilla.setPrefSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        this.grilla.setAlignment(Pos.CENTER);
        this.baseMapa.setCenter(grilla);
    }
    public void mostrarMapa() {
        if (this.grilla == null) {
            inicializarGrilla();
        }

        for (int i = 0; i < LONGITUD_FILAS_MAPA; i++) {

            for (int j = 0; j < LONGITUD_COLUMNAS_MAPA; j++) {

                Posicion posicion = new Posicion(i, j);
                Celda celda = mapa.obtenerCelda(posicion);

                String rutaSprite = celda.obtenerSprite();
                String rutaSpriteFinal = this.RUTA_A_SPRITES + rutaSprite;

                agregarSprite(rutaSpriteFinal, i, j);

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
    }


}
