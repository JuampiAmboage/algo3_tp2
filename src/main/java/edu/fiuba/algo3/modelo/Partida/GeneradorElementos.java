package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;

public class GeneradorElementos {

    private ArrayList<ArrayList<Celda>> mapa;
    private int longitudFilas;
    private int longitudColumnas;
    boolean primeraColocacion;

    public GeneradorElementos(ArrayList<ArrayList<Celda>> mapa, int longitudFilas, int longitudColumnas){
        this.longitudFilas = longitudFilas;
        this.longitudColumnas = longitudColumnas;
        this.primeraColocacion = true;
        this.mapa = mapa;
    }

    public void generarBase(Edificio baseJugador){
        if(primeraColocacion) {
            mapa.get(0).get((int) (Math.random() * longitudFilas)).ocuparPorTierra(baseJugador);
            primeraColocacion = false;
        }
        else
            mapa.get(longitudFilas-1).get((int) (Math.random() * longitudFilas)).ocuparPorTierra(baseJugador);
    }

}
