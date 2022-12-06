package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public abstract class Tropa extends Unidad {
    protected String superficie;
    protected int tiempoConstruccion;
    protected int danioTerrestre;
    protected int danioAereo;
    protected Edificio edificioNecesario;
    protected RangoAtaque rangoAtaque;
    protected Atacar ataque;

    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacarTierra(TropaTerrestre unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
    }
    public void atacarAire(TropaAerea unidadAtacable){ ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo);}
    public boolean existeEdificioNecesario(){
        return ComunidadZerg.obtenerInstanciaDeClase().existeUnidad(edificioNecesario);
    }
    public abstract void pasarTurno();
    public String obtenerSuperficie() {
        return superficie;
    }


}
