package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public abstract class Tropa extends Raza {
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
    public void atacarTierra(Raza unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
    }
    public void atacarAire(Raza unidadAtacable){ ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo);}
    public abstract void pasarTurno();
    public String obtenerSuperficie() {
        return superficie;
    }


}
