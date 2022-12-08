package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Excepciones.PosicionesDiferentes;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Unidad;

import java.util.ArrayList;

public class Mapa {
    private static Mapa singletonMapa;
    private ArrayList<ArrayList<Celda>> mapaJuego;
    private int longitudFilas; //alto mapa
    private int longitudColumnas;//ancho mapa

    private GeneradorElementos generadorElementos;

    private Mapa() {
        mapaJuego = new ArrayList<ArrayList<Celda>>();}

    public static Mapa getInstance() {
        if (singletonMapa == null)
            singletonMapa = new Mapa();
        return singletonMapa;
    }

    public void instanciarMapa(int longitudFilas, int longitudColumnas) {
        this.longitudFilas = longitudFilas;
        this.longitudColumnas = longitudColumnas;
        for (int i = 0; i < longitudFilas; i++) {
            mapaJuego.add(new ArrayList<Celda>());
            for (int j = 0; j < longitudColumnas; j++)
                mapaJuego.get(i).add(new Celda(i, j));
        }
        generadorElementos = new GeneradorElementos(mapaJuego,longitudFilas,longitudColumnas);
    }

    public void generarBase(Edificio baseJugador){
        generadorElementos.generarBase(baseJugador);
    }

    public Celda obtenerCelda(Posicion posicionDeBusqueda) {
        Celda celdaBuscada;
        for (ArrayList<Celda> fila : mapaJuego)
            for (Celda celda : fila) {
                if (celda.esMismaPosicion(posicionDeBusqueda))
                    return celda;
            }
        throw new CoordenadaFueraDeRango();
    }

    /*public void ocuparUnaCeldaPorTierra(Posicion posicionAOcupar, Unidad ocupante){
        this.obtenerCelda(posicionAOcupar).
    }*/

    public boolean estaPosicionEnLimites(Posicion unaPosicion) {
        return unaPosicion.estaEnLimites(longitudFilas, longitudColumnas);
    }
}