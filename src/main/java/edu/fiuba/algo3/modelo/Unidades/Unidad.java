package edu.fiuba.algo3.modelo.Unidades;

public class Unidad {
    protected String superficie;
    protected int costoMinerales;
    protected int costoGas;
    protected int tiempo_constuccion;
    protected int danioTerrestre;
    protected int danioAereo;
    protected int rango_ataque;
    protected int vida;
    protected Atacar ataque;

    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacar(Unidad unidadAtacable){
        ataque.atacar(unidadAtacable,danioTerrestre,danioAereo);
    }
    public void reducirVida(int puntosAtaque){
        vida -= puntosAtaque;
    }

    public String obtenerSuperficie() {
        return superficie;
    }

    public int obtenerVida(){ return vida;}
}
