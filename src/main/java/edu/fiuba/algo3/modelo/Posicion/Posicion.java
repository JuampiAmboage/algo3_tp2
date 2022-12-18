package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Recursos.Recurso;

import java.util.ArrayList;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int posicionFila, int posicionColumna){
        fila = posicionFila;
        columna = posicionColumna;
    }

    public boolean esMismaPosicion(Posicion posicionDeBusqueda){
        return posicionDeBusqueda.obtenerDistanciaA(fila, columna) == 0;
    }
    public double solicitarDistanciaAUnidad(Unidad unidadParaSolicitar){
        return unidadParaSolicitar.obtenerDistanciaA(fila,columna);
    }
   public double solicitarDistanciaARecurso(Recurso recursoParaSolicitar){
        return recursoParaSolicitar.obtenerDistanciaA(fila,columna);
    }
    public double obtenerDistanciaA(int posicionXDestino, int posicionYDestino){
        return Math.sqrt(Math.pow((posicionXDestino-fila),2)+Math.pow((posicionYDestino-columna),2));
    }
    public boolean estaEnLimites(int maxLongitudX, int maxLongitudY) {
        return this.fila >= 0 && this.fila < maxLongitudX && this.columna >= 0 && this.columna < maxLongitudY;
    }
    public ArrayList<Posicion> obtenerPosicionesEnRadio(int radio) {
        Mapa mapa = Mapa.getInstance();
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i = (this.fila - radio); i <= (this.fila + radio); i++) {
            for(int j = (this.columna - radio); j <= (this.columna + radio); j++) {
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
        return Mapa.getInstance().obtenerCelda(new Posicion(this.fila-1,this.columna));
    }
    public Celda obtenerCeldaInferior(){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.fila+1,this.columna));
    }
    public Celda obtenerCeldaIzquierda(){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.fila,this.columna-1));
    }
    public Celda obtenerCeldaDerecha(){
        return Mapa.getInstance().obtenerCelda(new Posicion(this.fila,this.columna+1));
    }
    public void movimientoSuperior(){ this.columna -= 1; }
    public void movimientoInferior(){
        this.columna += 1;
    }
    public void movimientoDerecha(){
        this.fila += 1;
    }
    public void movimientoIzquierda(){
        this.fila -= 1;
    }

    public int obtenerFila(){return fila;}
    public int obtenerColumna(){return columna;}
}
