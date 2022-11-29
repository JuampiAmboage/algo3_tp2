package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Excepciones.PosicionesDiferentes;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import javafx.geometry.Pos;

import java.util.ArrayList;

public class Posicion {
    private int X;
    private int Y;

    public Posicion(int posicionX, int posicionY){
        X = posicionX;
        Y = posicionY;
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
    public ArrayList<Posicion> obtenerPosicionesEnRadio(int radio, Mapa mapa) {
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i = this.X - radio; i <= this.X + radio; i++) {
            for(int j = this.Y - radio; j <= this.Y + radio; j++) {
                Posicion unaPosicion = new Posicion(i,j);
                if (mapa.estaPosicionEnLimites(unaPosicion)) {
                    posiciones.add(unaPosicion);
                }
            }
        }
        return posiciones;
    }
}
