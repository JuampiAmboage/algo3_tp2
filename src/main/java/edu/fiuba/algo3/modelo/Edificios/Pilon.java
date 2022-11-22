package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Pilon extends Edificio {
    RangoExpansible rango;
    public Pilon(){
        this.tiempoConstruccion = 5;
        vida =  new VidaConEscudo(300, 300);
        rango = new RangoExpansible(3);
    }
    public void instanciacionInicial(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        energizarCeldasEnRango();
    }

    private void energizarCeldasEnRango(){
        //Celda celda = Mapa.getInstance().obtenerCelda(posicion.obtenerPosicionX(),posicion.obtenerPosicionY());
        rango.expandir(new CeldaEnergizada(),posicion.obtenerPosicionX(),posicion.obtenerPosicionY());
    }

    public void desernegizar(){
        //Celda celda = Mapa.getInstance().obtenerCelda(posicion.obtenerPosicionX(),posicion.obtenerPosicionY());
        rango.expandir(new CeldaLibre(),posicion.obtenerPosicionX(), posicion.obtenerPosicionY());
    }
    public void pasarTurno(){
        vida.pasarTurno();
    }
    public int obtenerEscudo(){ return vida.getEscudoActual();}

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {}
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {}
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobre(Celda celda) {
        celda.quiereConstruir(this);
    }
}
