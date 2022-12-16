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

    public GeneradorElementos(int longitudFilas, int longitudColumnas){
        this.longitudFilas = longitudFilas;
        this.longitudColumnas = longitudColumnas;
        this.primeraColocacion = true;
    }

    public void generarBase(Edificio baseJugador){
        Mapa mapa = Mapa.getInstance();
        Posicion posicionBase;

        if(primeraColocacion) {
            posicionBase = new Posicion(0,(int) (Math.random() * longitudFilas-1));
            primeraColocacion = false;
        }
        else {
            posicionBase = new Posicion(longitudFilas-1,(int) (Math.random() * longitudFilas-1));
        }
        mapa.obtenerCelda(posicionBase).ocuparPorTierra(baseJugador);
        baseJugador.instanciacionesIniciales(posicionBase);

    }
    public int calcularTotalCeldas(){
        return longitudColumnas*longitudFilas;
    }

    public void generarRecursos(){
        generarVolcanes(15);
        generarNodos(15);
    }

    public void generarVolcanes(int porcentajeRecursoEnMapa){
        Celda celdaRandom;
        Volcan unVolcan;
        int totalCeldas = this.calcularTotalCeldas();
        int cantidadCeldasConEsteRecurso = (totalCeldas*porcentajeRecursoEnMapa)/100;
        for(int i=0; i<cantidadCeldasConEsteRecurso;i++) {
            Posicion posicionRandom = new Posicion((int) (Math.random() * longitudFilas-1), (int) (Math.random() * longitudColumnas-1));
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
            catch (CeldaOcupada celdaOcupada){
                continue;
            }
        }
    }




}
