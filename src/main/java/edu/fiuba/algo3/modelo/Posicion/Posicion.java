package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;

public class Posicion {
    private int X;
    private int Y;

    public Posicion(int posicionX, int posicionY){
        X = posicionX;
        Y = posicionY;
    }

    public void reposicionar(int nuevaPosicionX, int nuevaPosicionY){
        X = nuevaPosicionX;
        Y = nuevaPosicionY;
    }

    public int obtenerPosicionX(){
        return X;
    }

    public int obtenerPosicionY(){
        return Y;
    }

    public int obtenerDistanciaA(int posicionXDestino, int posicionYDestino){
        return Math.abs((posicionXDestino+posicionYDestino)-(X+Y));
    }

    public boolean sonCoolineales(int posicionXDestino, int posicionYDestino){
        return X == posicionXDestino || Y == posicionYDestino;
    }
}