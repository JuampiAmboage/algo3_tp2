package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Mapa {
    private static Mapa singletonMapa;
    private HashMap<Posicion,Celda> mapaJuego;
    private int longitudFilas; //alto mapa
    private int longitudColumnas;//ancho mapa
    private Mapa(){ mapaJuego = new HashMap<Posicion,Celda>();}
    public static Mapa getInstance(){
        if(singletonMapa == null)
            singletonMapa = new Mapa();
        return singletonMapa;
    }
    public void instanciarMapa(int longitudFilas, int longitudColumnas) {
        this.longitudFilas = longitudFilas;
        this.longitudColumnas = longitudColumnas;

        for (int i = 0; i < this.longitudFilas; i++) {
            for (int j = 0; j < this.longitudColumnas; j++) {
                mapaJuego.put(new Posicion(i,j),new Celda());
            }
        }
    }

    /*public Celda obtenerCelda(Posicion posicion) {
        Celda celdaBuscada = mapaJuego.get(posicion);
        if(celdaBuscada == null)
            throw new RuntimeException();
        return celdaBuscada;
    }*/

    public Celda obtenerCelda(int x, int y){
        Set<Posicion> setPosiciones = mapaJuego.keySet();
        for (Posicion posicion : setPosiciones) {
            if (x == posicion.obtenerPosicionX() && y == posicion.obtenerPosicionY())
                return mapaJuego.get(posicion);
        }
        throw new RuntimeException();
    }

    public int obtenerLongitudFilas(){
        return longitudFilas;
    }

    public int obtenerLongitudColumnas(){
        return longitudColumnas;
    }

    /*public ArrayList<Celda> obtenerCeldasAdyacentes(int celdaX, int celdaY) {
        return this.obtenerCeldasEnRadio(celdaX, celdaY, 1);
    }

    public ArrayList<Celda> obtenerCeldasEnRadio(int celdaX, int celdaY, int radio) {

         * La estructura para encontrar a las celdas en radio sería
         *
         * [x-1, y-1]   [x, y-1]   [x+1, y-1]
         *  [x-1, y]     [x,y]      [x+1, y]
         * [x-1, y+1]   [x, y+1]   [x+1, y+1]
         *
         *
        ArrayList<Celda> enRadio = new ArrayList<>();
*/
       /* for (int x = celdaX - radio; x <= celdaX + radio; x++) {
            for (int y = celdaY - radio; y <= celdaY + radio; y++) {
                if (x < 0 || x >= tam || y < 0 || y >= tam || (x == celdaX && y == celdaY)) {
                    continue;
                }
                enRadio.add(this.obtenerCelda(x,y));
            }
        }
        return enRadio;
    }

    public ArrayList<Celda> obtenerCeldasEnRadio(Celda celda, int radio) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (this.celdas[i][j] == celda) {
                    return this.obtenerCeldasEnRadio(i, j, radio);
                }
            }
        }
        return null;
    }

    public int obtenerTamanio(){
        return tam;
    }

    public void pasarTurno() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                this.celdas[i][j].pasarTurno();
            }
        }
    }*/
}
