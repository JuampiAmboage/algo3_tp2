package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class RangoAtaque {
    int radio;
    public RangoAtaque(int radio) {
        this.radio = radio;
    }

    public void localizarTropaEnRango(Racita victima, int puntosAtaque, int X, int Y){
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
