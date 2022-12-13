package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.Atacar;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.EdificioHabilitadorNoCreado;
import edu.fiuba.algo3.modelo.Opciones.MoverseADerecha;
import edu.fiuba.algo3.modelo.Opciones.MoverseAIzquierda;
import edu.fiuba.algo3.modelo.Opciones.MoverseHaciaAbajo;
import edu.fiuba.algo3.modelo.Opciones.MoverseHaciaArriba;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Correlatividad;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;

public abstract class Tropa extends Unidad implements Correlatividad {
    protected int danioTerrestre;
    protected int danioAereo;
    protected Edificio edificioNecesario;
    protected Atacar ataque;
    protected RangoAtaque rangoAtaque;
    protected int cantidadMovimientos;
    public Tropa(){
        super();
        visibilidad = new Visible(this);
        cantidadMovimientos = 0;
        opciones.add(new MoverseHaciaArriba());
        opciones.add(new MoverseHaciaAbajo());
        opciones.add(new MoverseAIzquierda());
        opciones.add(new MoverseADerecha());
    }
    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacarTierra(TropaTerrestre unidadAtacable){
        this.esUsable();
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
    }
    public void atacarAire(TropaAerea unidadAtacable){ this.esUsable();
        ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo);}

    public void existeEdificioNecesario() {
        if(!ComunidadZerg.obtenerInstanciaDeClase().existeUnidad(edificioNecesario)){
            throw new EdificioHabilitadorNoCreado();
        }
    }
    public abstract void ocuparCelda(Celda celda);
    public abstract void moverArriba();

    public abstract void moverAbajo();
    public abstract void moverDerecha();

    public abstract void moverIzquierda();
}
