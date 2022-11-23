package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Excepciones.PosicionesDiferentes;

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

    public void compararPosiciones(Posicion posicionDeBusqueda) throws PosicionesDiferentes{
        if (X != posicionDeBusqueda.obtenerPosicionX() || Y != posicionDeBusqueda.obtenerPosicionY())
            throw new PosicionesDiferentes();
    }

    public int obtenerDistanciaA(int posicionXDestino, int posicionYDestino){
        return Math.abs((posicionXDestino+posicionYDestino)-(X+Y));
    }

    public int obtenerPosicionX(){
        return X;
    }
    public int obtenerPosicionY(){
        return Y;
    }

    public boolean estaEnLimites(int maxLongitudX, int maxLongitudY) {
        return this.X > 0 && this.X < maxLongitudX && this.Y > 0 && this.Y < maxLongitudY;
    }
}
