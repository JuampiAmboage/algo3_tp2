package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.File;

public class ControladorVistaMapa {

    private final Mapa mapa = Mapa.getInstance();
    private final String RUTA_A_SPRITES = "/sprites";
    private final int LONGITUD_FILAS_MAPA = 10; // Alto mapa;
    private final int LONGITUD_COLUMNAS_MAPA = 10;// Ancho mapa

    private double Siguienteubcacion = 0;

    @FXML
    private AnchorPane baseMapa;

    public void mostrarMapa() {

        for (int i = 0; i < LONGITUD_FILAS_MAPA; i++) {

            for (int j = 0; j < LONGITUD_COLUMNAS_MAPA; j++) {

                Posicion posicion = new Posicion(i, j);
                Celda celda = mapa.obtenerCelda(posicion);

                String rutaSprite = celda.obtenerSprite();
                String rutaSpriteFinal = this.RUTA_A_SPRITES + rutaSprite;

                crearTileSet();
                agregarSprite(rutaSpriteFinal, i, j);

            }

        }

    }

    public void crearTileSet() {

    }

    public void agregarSprite(String rutaSprite, int fila, int columna) {

        Image imagen = new Image(new File(rutaSprite).toURI().toString());
        ImageView sprite = new ImageView();

        sprite.setFitHeight(70.0);
        sprite.setFitHeight(70.0);
        sprite.setImage(imagen);

    }


}
