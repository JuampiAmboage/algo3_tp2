package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recurso;
import edu.fiuba.algo3.modelo.Recursos.Volcan;

import java.util.ArrayList;

public class GeneradorElementos {

    private int longitudFilas;
    private int longitudColumnas;
    boolean primeraColocacion;

    public GeneradorElementos(int longitudFilas, int longitudColumnas) {
        this.longitudFilas = longitudFilas;
        this.longitudColumnas = longitudColumnas;
        this.primeraColocacion = true;
    }

    public void generarBase(Edificio baseJugador) {
        Mapa mapa = Mapa.getInstance();
        Posicion posicionBase;

        if (primeraColocacion) {
            posicionBase = new Posicion(0, (int) (Math.random() * longitudFilas - 1));
            primeraColocacion = false;
        } else {
            posicionBase = new Posicion(longitudFilas - 1, (int) (Math.random() * longitudFilas - 1));
        }
        mapa.obtenerCelda(posicionBase).ocuparPorTierra(baseJugador);
        baseJugador.instanciacionesIniciales(posicionBase);

    }

    public int calcularTotalCeldas() {
        return longitudColumnas * longitudFilas;
    }

    public void generarRecursos(int porcentajeRecursosEnMapa) {
        int totalCeldas = this.calcularTotalCeldas();
        int cantidadCeldasConRecurso = (totalCeldas * porcentajeRecursosEnMapa) / 100;
        int quincePorCientoCeldasConRecurso = (cantidadCeldasConRecurso * 15) / 100;
        int ochentaYCincoPorCientoCeldasConRecurso = (cantidadCeldasConRecurso * 85) / 10;
        for (int i = 0; i < quincePorCientoCeldasConRecurso; i++) {
            generarRecurso(new Volcan(), 0, 1);
            generarRecurso(new Volcan(), 9, 10);
            generarRecurso(new NodoMineral(), 0, 1);
            generarRecurso(new NodoMineral(), 9, 10);
        }
        for (int i = 0; i < ochentaYCincoPorCientoCeldasConRecurso; i++) {
            generarRecurso(new Volcan(), 2, 8);
            generarRecurso(new NodoMineral(), 2, 8);
        }
    }

    public void generarRecurso(Recurso recursoAGenerar, int minFila, int maxFila) {
        Celda celdaRandom;
        Posicion posicionRandom = new Posicion((int) (Math.random() * ((maxFila-minFila+1)+minFila)), (int) (Math.random() * longitudColumnas));
        try {
            celdaRandom = Mapa.getInstance().obtenerCelda(posicionRandom);
            celdaRandom.estaOcupadaPorTierra();
            celdaRandom.agregarRecurso(recursoAGenerar);
        }
        catch (CeldaOcupada ignore){}
    }

    public void generarVolcanes(int porcentajeRecursoEnMapa){
        Celda celdaRandom;
        Volcan unVolcan;
        int totalCeldas = this.calcularTotalCeldas();
        int cantidadCeldasConEsteRecurso = (totalCeldas*porcentajeRecursoEnMapa)/100;
        for(int i=0; i<cantidadCeldasConEsteRecurso;i++) {
            Posicion posicionRandom = new Posicion((int) (Math.random() * ((longitudColumnas-3+1)-3)+3), (int) (Math.random() * longitudColumnas-1));
            try {
                celdaRandom = Mapa.getInstance().obtenerCelda(posicionRandom);
                celdaRandom.estaOcupadaPorTierra();
                unVolcan= new Volcan();
                celdaRandom.agregarRecurso(unVolcan);
            }
            catch (CeldaOcupada celdaOcupada){
                continue;
            }
        }
    }

    public void generarNodos(int porcentajeRecursoEnMapa){
        Celda celdaRandom;
        NodoMineral unNodo;
        int totalCeldas = this.calcularTotalCeldas();
        int cantidadCeldasConEsteRecurso = (totalCeldas*porcentajeRecursoEnMapa)/100;
        for(int i=0; i<cantidadCeldasConEsteRecurso;i++) {
            Posicion posicionRandom = new Posicion((int) (Math.random() * longitudFilas-1), (int) (Math.random() * longitudColumnas-1));
            try {
                celdaRandom = Mapa.getInstance().obtenerCelda(posicionRandom);
                celdaRandom.estaOcupadaPorTierra();
                unNodo = new NodoMineral();
                celdaRandom.agregarRecurso(unNodo);
            }
            catch (CeldaOcupada ignore){}
        }
    }




}
