package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import java.util.ArrayList;

public class Mapa {

    private final Celda[][] celdas;
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
                celdas[i][j].setAdyacentes(this.obtenerCeldasAdyacentes(i, j));
            }
        }
    }

    public Celda obtenerCelda(int x, int y) {
        return celdas[x][y];
    }

    public ArrayList<Celda> obtenerCeldasAdyacentes(int celdaX, int celdaY) {

        return this.obtenerCeldasEnRadio(celdaX, celdaY, 1);
    }

    public ArrayList<Celda> obtenerCeldasEnRadio(int celdaX, int celdaY, int radio) {
        /*
         * La estructura para encontrar a las celdas en radio sería
         *
         * [x-1, y-1]   [x, y-1]   [x+1, y-1]
         *  [x-1, y]     [x,y]      [x+1, y]
         * [x-1, y+1]   [x, y+1]   [x+1, y+1]
         *
         * */
        ArrayList<Celda> enRadio = new ArrayList<>();

        for (int x = celdaX - radio; x <= celdaX + radio; x++) {
            for (int y = celdaY - radio; y <= celdaY + radio; y++) {
                if (x < 0 || x >= tam || y < 0 || y >= tam || (x == celdaX && y == celdaY)) {
                    continue;
                }
                enRadio.add(this.obtenerCelda(x,y));
            }
        }
        return enRadio;
    }
}
