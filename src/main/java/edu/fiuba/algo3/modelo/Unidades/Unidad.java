package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;

public abstract class Unidad extends Racita{
    protected String superficie;
    protected int costoMinerales;
    protected int costoGas;
    protected int tiempo_constuccion;
    protected int danioTerrestre;
    protected int danioAereo;
    protected int rango_ataque;
    protected Atacar ataque;

    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacarTierra(Racita unidadAtacable){
        ataque.atacarTierra(unidadAtacable,danioTerrestre);
    }
    public void atacarAire(Racita unidadAtacable){ ataque.atacarAire(unidadAtacable,danioAereo);}
    public abstract void pasarTurno();
    public String obtenerSuperficie() {
        return superficie;
    }


}
