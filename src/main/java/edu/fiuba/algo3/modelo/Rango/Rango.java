package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public class Rango {
    private final int radio;
    protected final ArrayList<Posicion> posicionesEnRango;
    protected final Posicion posicionOrigen;

    public Rango(Posicion posicionOrigen, int radio) {
        this.posicionOrigen = posicionOrigen;
        this.radio = radio;
        this.posicionesEnRango = this.crearPosiciones();
    }

    protected ArrayList<Posicion> crearPosiciones() {
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Mapa mapa = Mapa.getInstance();

        for(
            int i = posicionOrigen.obtenerPosicionX() - radio;
            i <= posicionOrigen.obtenerPosicionX() + radio;
            i++
        ) {
            for(
                int j = posicionOrigen.obtenerPosicionY() - radio;
                j <= posicionOrigen.obtenerPosicionY();
                j++
            ) {
                Posicion unaPosicion = new Posicion(i,j);
                if (mapa.estaPosicionEnLimites(unaPosicion)) {
                    posiciones.add(unaPosicion);
                }
            }
        }
        return posiciones;
    }

}
