package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.ComunidadNueva.Comunidad;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Asimilador extends Edificio {
    private Salud vida;
    public Asimilador() {
        this.tiempoDeConstruccion = 6;
        vida = new VidaConEscudo(450, 450);
    }
    public void pasarTurno(){
        ComunidadProtoss.obtenerInstanciaDeClase().aniadirGasVespeno(extraerGas());
        vida.pasarTurno();
    }
    public int extraerGas(){
        return 20;
    }
    public int obtenerEscudo(){
        return vida.getEscudoActual();
    }

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {}
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobre(Celda celda) {
        celda.quiereConstruir(this);
    }
}
