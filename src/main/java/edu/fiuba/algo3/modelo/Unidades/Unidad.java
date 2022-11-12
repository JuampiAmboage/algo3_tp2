package edu.fiuba.algo3.modelo.Unidades;

public class Unidad {
    protected int costoMinerales;
    protected int costoGas;
    protected int tiempo_constuccion;
    protected int danio;
    protected int rango_ataque;
    protected int vida;
    protected Atacar ataque;

    public int obtenerDanio(){
        return danio;
    }
    public void atacar(Unidad unidadAtacable){
        ataque.atacar(unidadAtacable,danio);
    }
    public void reducirVida(int puntosAtaque){
        vida -= puntosAtaque;
    }
}
