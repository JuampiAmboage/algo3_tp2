package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Excepciones.PosicionesDiferentes;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Map;

public class Posicion {
    private int X;
    private int Y;

    public Posicion(int posicionX, int posicionY){
        X = posicionX;
        Y = posicionY;
    }

    public boolean esMismaPosicion(Posicion posicionDeBusqueda){
        return posicionDeBusqueda.obtenerDistanciaA(X, Y) == 0;
    }
    public int solicitarDistanciaA(Unidad unidadParaSolicitar){
        return unidadParaSolicitar.obtenerDistanciaA(X,Y);
    }
    public int obtenerDistanciaA(int posicionXDestino, int posicionYDestino){
        return Math.abs((posicionXDestino+posicionYDestino)-(X+Y));
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
    public Celda obtenerUnaCeldaLimitrofe(int desplazamientoX, int desplazamientoY){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.X+desplazamientoX,this.Y+desplazamientoY));
    }

    public void movimientoSuperior(){
        this.X -= 1;
    }
    public void movimientoInferior(){
        this.X += 1;
    }
    public void movimientoDerecha(){
        this.Y += 1;
    }
    public void movimientoIzquierda(){
        this.Y -= 1;
    }

}
