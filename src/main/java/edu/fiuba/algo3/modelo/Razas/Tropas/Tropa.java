package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Correlatividad;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public abstract class Tropa extends Unidad implements Correlatividad {
    protected int tiempoConstruccion;
    protected int danioTerrestre;
    protected int danioAereo;
    protected Edificio edificioNecesario;
    protected Atacar ataque;
    protected RangoAtaque rangoAtaque;
    public Tropa(){
        visibilidad = new Visible(this);
    }
    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacarTierra(TropaTerrestre unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
    }
    public void atacarAire(TropaAerea unidadAtacable){ ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo);}
    public abstract void pasarTurno();

    public boolean existeEdificioNecesario() {
        return ComunidadZerg.obtenerInstanciaDeClase().existeUnidad(edificioNecesario);
    }
    public abstract void moverArriba();

    public abstract void moverAbajo();
    public abstract void moverDerecha();

    public abstract void moverIzquierda();
}
