package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public abstract class Tropa extends Racita{
    protected String superficie;
    protected int costoMinerales;
    protected int costoGas;
    protected int tiempoConstruccion;
    protected int danioTerrestre;
    protected int danioAereo;
    protected RangoAtaque rangoAtaque;
    protected Atacar ataque;

    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacarTierra(Racita unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre,posicion.obtenerPosicionX(), posicion.obtenerPosicionY());
    }
    public void atacarAire(Racita unidadAtacable){ ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo,posicion.obtenerPosicionX(),posicion.obtenerPosicionY());}
    public abstract void pasarTurno();
    public String obtenerSuperficie() {
        return superficie;
    }


}
