package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Ataque.Atacar;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Excepciones.EdificioHabilitadorNoCreado;
import edu.fiuba.algo3.modelo.Excepciones.SinMasMovimientos;
import edu.fiuba.algo3.modelo.Opciones.AtaqueTropaTerrestre;
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
    protected int cantidadAtaques;
    public Tropa(){
        super();
        visibilidad = new Visible(this);
        cantidadMovimientos = 0;
        cantidadAtaques = 0;
    }
    public abstract void realizarAccionesTurno();

    public int obtenerDanioTerrestre(){
        return danioTerrestre;
    }
    public int obtenerDanioAereo(){ return danioAereo;}
    public void atacarTierra(Unidad unidadAtacable){
        this.esUsable();
        this.tieneAtaques();
        this.ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
        this.cantidadAtaques++;
    }
    public void atacarAire(TropaAerea unidadAtacable){ this.esUsable();
        this.esUsable();
        this.tieneAtaques();
        this.ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo);
        this.cantidadAtaques++;
    }

    public void existeEdificioNecesario() {
        if(!ComunidadZerg.obtenerInstanciaDeClase().existeUnidad(edificioNecesario)){
            throw new EdificioHabilitadorNoCreado();
        }
    }
    public void tieneMovimientos(){
        if(this.cantidadMovimientos >= 3){
            throw new SinMasMovimientos();
        }
    }
    public void tieneAtaques(){
        if(this.cantidadAtaques >= 5){
            throw new SinMasMovimientos();
        }
    }

    public void mover(Celda celdaDestino){
        this.tieneMovimientos();
        this.ocuparCelda(celdaDestino);

    }
    public void moverArriba(){
        this.estado.esUsable();
        Celda celdaDestino = posicion.obtenerCeldaSuperior();
        try {
            this.mover(celdaDestino);
            this.posicion.movimientoSuperior();
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }

    public void moverAbajo(){
        this.estado.esUsable();
        Celda celdaDestino = posicion.obtenerCeldaInferior();
        try {
            this.mover(celdaDestino);
            this.posicion.movimientoInferior();
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }
    public void moverDerecha(){
        this.estado.esUsable();
        Celda celdaDestino = posicion.obtenerCeldaDerecha();
        try {
            this.mover(celdaDestino);
            this.posicion.movimientoDerecha();
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }
    public void moverIzquierda(){
        this.estado.esUsable();
        Celda celdaDestino = posicion.obtenerCeldaIzquierda();
        try {
            this.mover(celdaDestino);
            this.posicion.movimientoIzquierda();
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }
    public abstract void ocuparCelda(Celda celda);

}
