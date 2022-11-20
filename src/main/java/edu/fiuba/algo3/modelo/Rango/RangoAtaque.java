package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Racita;

public class RangoAtaque {
    Posicion posicion;
    int radio;
    public RangoAtaque(int radio, Posicion posicionObjetoConRango) {
        this.radio = radio;
        posicion = posicionObjetoConRango;
    }
    public void localizarTropaEnRango(Racita victima, int puntosAtaque){
        int Xvictima = victima.obtenerPosicion().obtenerPosicionX();
        int Yvictima = victima.obtenerPosicion().obtenerPosicionY();
        if(posicion.obtenerDistanciaA(Xvictima,Yvictima) <= radio){
            victima.daniar(puntosAtaque);
        }
        else{
            throw new RuntimeException(); //throw new EnemigoFueraDeRango()
        }
    }
}
