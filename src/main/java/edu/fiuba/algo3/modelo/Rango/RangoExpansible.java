package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Celdas.TipoCelda;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoExpansible {
    int radio;

    public RangoExpansible(int radio) {
        this.radio = radio;
    }

    public void modificarRadio(int nuevoRadio) {
        radio = nuevoRadio;
    }

    public void expandir(TipoCelda tipoCeldaAConvertir,int posicionXCeldaActual, int posicionYCeldaActual) {
        Mapa mapa = Mapa.getInstance();
        for (int i = 1; i <= radio; i++) {
            mapa.obtenerCelda(posicionXCeldaActual + i, posicionYCeldaActual).cambiarTipo(tipoCeldaAConvertir);
            mapa.obtenerCelda(posicionXCeldaActual - i, posicionYCeldaActual).cambiarTipo(tipoCeldaAConvertir);
            mapa.obtenerCelda(posicionXCeldaActual, posicionYCeldaActual + i).cambiarTipo(tipoCeldaAConvertir);
            mapa.obtenerCelda(posicionXCeldaActual, posicionYCeldaActual - i).cambiarTipo(tipoCeldaAConvertir);
        }
    }
}