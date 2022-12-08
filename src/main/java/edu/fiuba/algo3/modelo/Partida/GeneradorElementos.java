package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recurso;
import edu.fiuba.algo3.modelo.Recursos.Volcan;

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
    public int calcularTotalCeldas(){
        return longitudColumnas*longitudFilas;
    }

    public void generarRecursos(){
        generarVolcanes(15);
        generarNodos(15);
    }

    public void generarVolcanes(int porcentajeRecursoEnMapa){
        int totalCeldas = this.calcularTotalCeldas();
        int cantidadCeldasConEsteRecurso = (totalCeldas*porcentajeRecursoEnMapa)/100;
        for(int i=0; i<totalCeldas;i++) {
            Posicion posicionRandom = new Posicion((int) (Math.random() * longitudFilas), (int) (Math.random() * longitudColumnas));
            while (Mapa.getInstance().obtenerCelda(posicionRandom).estaOcupadaPorTierra()){
                posicionRandom = new Posicion((int) (Math.random() * longitudFilas), (int) (Math.random() * longitudColumnas));
            }
            Volcan unVolcan = new Volcan();
            Mapa.getInstance().obtenerCelda(posicionRandom).agregarRecurso(unVolcan);
        }
    }

    public void generarNodos(int porcentajeRecursoEnMapa){
        int totalCeldas = this.calcularTotalCeldas();
        int cantidadCeldasConEsteRecurso = (totalCeldas*porcentajeRecursoEnMapa)/100;
        for(int i=0; i<totalCeldas;i++) {
            Posicion posicionRandom = new Posicion((int) (Math.random() * longitudFilas), (int) (Math.random() * longitudColumnas));
            while (Mapa.getInstance().obtenerCelda(posicionRandom).estaOcupadaPorTierra()){
                posicionRandom = new Posicion((int) (Math.random() * longitudFilas), (int) (Math.random() * longitudColumnas));
            }
            NodoMineral unNodoMineral = new NodoMineral();
            Mapa.getInstance().obtenerCelda(posicionRandom).agregarRecurso(unNodoMineral);
        }
    }




}
