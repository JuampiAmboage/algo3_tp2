package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
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
    private ArrayList<Celda> celdasConTropas = new ArrayList<>();

    private ArrayList<ControladorVistaMenuJugadores> controladoresJugadores = new ArrayList<>();
    private boolean seActualizo = false;

    private void inicializarGrilla() {
        this.grilla = new GridPane();
        this.grilla.setGridLinesVisible(true);

        this.grilla.setMaxSize(700.0, 700.0);
        this.grilla.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        this.grilla.setPrefSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        this.grilla.setAlignment(Pos.CENTER);
        this.grilla.setId("grilla");

        this.grilla.setRotate(90.0);

        this.baseMapa.setCenter(grilla);
    }

    public void establecerApp(App app) { this.app = app; }
    public void establecerControladores(ControladorVistaMenuJugadorUno controladorJugadorUno, ControladorVistaMenuJugadorDos controladorJugadorDos) {
        this.controladoresJugadores.add(controladorJugadorUno);
        this.controladoresJugadores.add(controladorJugadorDos);
    }

    public void mostrarMapa() {

        if (this.grilla == null) {
            inicializarGrilla();
        }

        pedirSprites();

        if (this.seActualizo) {
            actualizarMapa();
            this.seActualizo = true;
        }

    }

    public void pedirSprites() {
        this.celdasConExtractor.clear();
        this.celdasConTropas.clear();

        for (int fila = 0; fila < LONGITUD_FILAS_MAPA; fila++) {

            for (int columna = 0; columna < LONGITUD_COLUMNAS_MAPA; columna++) {

                Posicion posicion = new Posicion(fila, columna);
                Celda celda = mapa.obtenerCelda(posicion);

                if (celda.obtenerOcupanteTerrestre() instanceof Extractor) {
                    this.celdasConExtractor.add(celda);
                } else if (celda.obtenerOcupanteTerrestre().existe() || celda.obtenerOcupanteAereo().existe()) {
                    this.celdasConTropas.add(celda);
                }

                String spriteTipo = celda.obtenerSpriteTipo();
                if (spriteTipo != null) {
                    agregarSprite(spriteTipo, fila, columna);
                }

                String spriteRecurso = celda.obtenerSpriteRecurso();
                if (spriteRecurso != null) {
                    agregarSprite(spriteRecurso, fila, columna);
                }

                String spriteOcupanteTerrestre = celda.obtenerSpriteOcupanteTerrestre();
                if (spriteOcupanteTerrestre != null) {
                    agregarSprite(spriteOcupanteTerrestre, fila, columna);
                }

                String spriteOcupanteAero = celda.obtenerSpriteOcupanteAereo();
                if (spriteOcupanteAero != null) {
                    agregarSprite(spriteOcupanteAero, fila, columna);
                }

                agregarBotonCelda(fila, columna);

            }

        }
    }

    public void actualizarMapa(){
        this.grilla.getChildren().clear();
        pedirSprites();
    }

    public void agregarSprite(String rutaSprite,int fila,int columna) {

        Image imagen = new Image(getClass().getResourceAsStream(rutaSprite));

        ImageView sprite = new ImageView();
        sprite.setFitWidth(70.0);
        sprite.setFitHeight(70.0);
        sprite.setImage(imagen);

        sprite.setRotate(-90.0);

        this.grilla.add(sprite, fila, columna);
    }

    public void agregarBotonCelda(int fila, int columna) {

        BotonCelda botonCelda = new BotonCelda(fila, columna, this);

        this.grilla.add(botonCelda.obtenerBotonNodo(), fila, columna);
    }

    public void gestionarClickEnCelda(int fila, int columna, Button boton) {
        Posicion posicion = new Posicion(fila, columna);
        Celda celda = mapa.obtenerCelda(posicion);

        desactivarBoton(boton);

        app.mostrarMenu(celda.gestionarOpcionesParaJugador(), celda);
    }


    public ArrayList<Celda> obtenerCeldasConExtractor() {
        return this.celdasConExtractor;
    }

    public ArrayList<Celda> obtenerCeldasConTropas() {
        return this.celdasConTropas;
    }

    private void desactivarBoton(Button boton) {

        if (this.botonAnterior != null) {
            this.botonAnterior.setDisable(false);
        }
        boton.setDisable(true);
        this.botonAnterior = boton;
    }

    public void cambiarBotonAAtaque(Celda celdaAtacada, OpcionElegible opcion, Celda celdaAtacante, String opcionElejida) {
        BotonAtaque botonAtaque = new BotonAtaque(celdaAtacada, opcion, celdaAtacante, this.controladoresJugadores.get(0), opcionElejida);

        Posicion posicion = celdaAtacada.obtenerPosicion();
        this.grilla.add(botonAtaque.obtenerBotonNodo(), posicion.obtenerFila(), posicion.obtenerColumna());
    }

}
