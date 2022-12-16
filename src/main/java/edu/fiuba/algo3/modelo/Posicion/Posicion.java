package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Recursos.Recurso;

import java.util.ArrayList;

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
    public double solicitarDistanciaAUnidad(Unidad unidadParaSolicitar){
        return unidadParaSolicitar.obtenerDistanciaA(X,Y);
    }
   public double solicitarDistanciaARecurso(Recurso recursoParaSolicitar){
        return recursoParaSolicitar.obtenerDistanciaA(X,Y);
    }
    public double obtenerDistanciaA(int posicionXDestino, int posicionYDestino){
        return Math.sqrt(Math.pow((posicionXDestino-X),2)+Math.pow((posicionYDestino-Y),2));
    }
    public boolean estaEnLimites(int maxLongitudX, int maxLongitudY) {
        return this.X >= 0 && this.X < maxLongitudX && this.Y >= 0 && this.Y < maxLongitudY;
    }
    public ArrayList<Posicion> obtenerPosicionesEnRadio(int radio) {
        Mapa mapa = Mapa.getInstance();
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i = (this.X - radio); i <= (this.X + radio); i++) {
            for(int j = (this.Y - radio); j <= (this.Y + radio); j++) {
                Posicion unaPosicion = new Posicion(i,j);
                if (mapa.estaPosicionEnLimites(unaPosicion)) {
                    posiciones.add(unaPosicion);
                }
            }
        }
        return posiciones;
    }
    /*public Celda obtenerUnaCeldaLimitrofe(int desplazamientoX, int desplazamientoY){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.X+desplazamientoX,this.Y+desplazamientoY));
    }*/

    public Celda obtenerCeldaSuperior(){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.X,this.Y-1));
    }
    public Celda obtenerCeldaInferior(){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.X,this.Y+1));
    }
    public Celda obtenerCeldaIzquierda(){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.X-1,this.Y));
    }
    public Celda obtenerCeldaDerecha(){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.X+1,this.Y));
    }
    public void movimientoSuperior(){
        this.Y -= 1;
    }
    public void movimientoInferior(){
        this.Y += 1;
    }
    public void movimientoDerecha(){
        this.X += 1;
    }
    public void movimientoIzquierda(){
        this.X -= 1;
    }

}
