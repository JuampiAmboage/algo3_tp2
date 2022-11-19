package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Mapa;
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
    }
    //FUNCION OBSOLETA
    public void localizarTropaEnRangoVieja(Racita victima, int puntosAtaque, int X, int Y){
        Mapa mapa = Mapa.getInstance();
        int radioRecorrido = 1;
        boolean tropaLocalizada = false;
        while(radioRecorrido <= radio && !tropaLocalizada){
            if (mapa.obtenerCelda(X + radioRecorrido, Y).obtenerOcupante() == victima ||
            mapa.obtenerCelda(X - radioRecorrido, Y).obtenerOcupante() == victima ||
            mapa.obtenerCelda(X, Y + radioRecorrido).obtenerOcupante() == victima ||
            mapa.obtenerCelda(X, Y - radioRecorrido).obtenerOcupante() == victima) {
                victima.daniar(puntosAtaque);
                tropaLocalizada = true;
            }
            else
                radioRecorrido++;
        }
        /*if(!tropaLocalizada)
            throw new //tropaFueraDeRangoDeAtaque*/
    }
}
