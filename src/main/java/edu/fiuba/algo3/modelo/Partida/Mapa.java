package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public class Mapa {
    private static Mapa singletonMapa;
    private ArrayList<ArrayList<Celda>> mapaJuego;
    private final int LONGITUD_FILAS_MAPA = 10; // Alto mapa
    private final int LONGITUD_COLUMNAS_MAPA = 10;// Ancho mapa

    private GeneradorElementos generadorElementos;

    private Mapa() { mapaJuego = new ArrayList<ArrayList<Celda>>(); }

    public static Mapa getInstance() {
        if (singletonMapa == null)
            singletonMapa = new Mapa();
        return singletonMapa;
    }

    public void instanciarMapa() {
        for (int i = 0; i < LONGITUD_FILAS_MAPA; i++) {
            mapaJuego.add(new ArrayList<Celda>());
            for (int j = 0; j < LONGITUD_COLUMNAS_MAPA; j++)
                mapaJuego.get(i).add(new Celda(i, j));
        }
        generadorElementos = new GeneradorElementos(LONGITUD_FILAS_MAPA,LONGITUD_COLUMNAS_MAPA);
    }

    public void generarBase(Edificio baseJugador){
        generadorElementos.generarBase(baseJugador);
    }

    public Celda obtenerCelda(Posicion posicionDeBusqueda) {
        //Celda celdaBuscada;
        for (ArrayList<Celda> fila : mapaJuego)
            for (Celda celda : fila) {
                if (celda.esMismaPosicion(posicionDeBusqueda))
                    return celda;
            }
        throw new CoordenadaFueraDeRango();
    }

    public void generarRecursos(){
        generadorElementos.generarRecursos();
    }
    public void pasarTurno(){
        for (ArrayList<Celda> fila : mapaJuego){
            for (Celda celda : fila) {
                celda.pasarTurno();
            }
        }
    }
    /*public void ocuparUnaCeldaPorTierra(Posicion posicionAOcupar, Unidad ocupante){
        this.obtenerCelda(posicionAOcupar).
    }*/

    public boolean estaPosicionEnLimites(Posicion unaPosicion) {
        return unaPosicion.estaEnLimites(this.LONGITUD_FILAS_MAPA, this.LONGITUD_COLUMNAS_MAPA);
    }
}