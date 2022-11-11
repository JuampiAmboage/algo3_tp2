package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import java.util.ArrayList;

public class Mapa {

    private Celda[][] celdas;
    private final int tam; // Tamaño del mapa

    public Mapa(int tamTotal) {
        this.tam = tamTotal;
        this.celdas = new Celda[tam][tam];
        // establezco las celdas en radio

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                // cambio las posiciones de NULL a Celda
                celdas[i][j] = new Celda();
            }
        }
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                // cambio las posiciones de NULL a Celda
                celdas[i][j].setAdyacentes(this.obtenerCeldasAdyacentes(i, j));
            }
        }
    }

    public Celda obtenerCelda(int x, int y) {
        return celdas[x][y];
    }

    public ArrayList<Celda> obtenerCeldasAdyacentes(int celdaX, int celdaY) {
        /*
        * La estructura para encontrar a las celdas en radio sería
        *
        * [x-1, y-1]   [x, y-1]   [x+1, y-1]
        *  [x-1, y]     [x,y]      [x+1, y]
        * [x-1, y+1]   [x, y+1]   [x+1, y+1]
        *
        * */
        ArrayList<Celda> adyacentes = new ArrayList<Celda>();

        for (int x = celdaX - 1; x <= celdaX + 1; x++) {
            for (int y = celdaY - 1; y <= celdaY + 1; y++) {
                if (x < 0 || x >= tam || y < 0 || y >= tam || (x == celdaX && y == celdaY)) {
                    continue;
                }
                adyacentes.add(this.obtenerCelda(x,y));
            }
        }
        return adyacentes;
    }

}
