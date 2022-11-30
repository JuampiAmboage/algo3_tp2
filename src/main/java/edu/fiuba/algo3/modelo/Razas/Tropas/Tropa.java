package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public abstract class Tropa extends Unidad {
    protected String superficie;
    protected int tiempoConstruccion;
    protected int danioTerrestre;
    protected int danioAereo;
    protected RangoAtaque rangoAtaque;
    protected Atacar ataque;

    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacarTierra(Unidad unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
    }
    public void atacarAire(Unidad unidadAtacable){ ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo);}
    public abstract void pasarTurno();
    public String obtenerSuperficie() {
        return superficie;
    }


}
