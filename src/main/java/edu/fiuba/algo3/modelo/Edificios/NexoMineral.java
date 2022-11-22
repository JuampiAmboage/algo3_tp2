package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class NexoMineral extends Edificio implements Construible{

    public NexoMineral(){
        tiempoDeConstruccion = 4;
        vida = new VidaConEscudo(250,250);
    }
    @Override
    public void pasarTurno(){
        vida.pasarTurno();
    }
    public int obtenerEscudo(){ return vida.getEscudoActual();}

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {throw new ConstruccionProhibida();}
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {}
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {throw new ConstruccionProhibida();}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobre(Celda celda) throws ConstruccionProhibida{
        celda.quiereConstruir(this);
    }

}
