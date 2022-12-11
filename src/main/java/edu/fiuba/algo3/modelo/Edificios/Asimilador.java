package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Razas.Tropas.Visible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Asimilador extends Edificio {
    Volcan volcan;
    public Asimilador(Volcan volcan) {
        this.tiempoConstruccion = 6;
        this.vida = new VidaConEscudo(450, 450);
        this.comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        this.volcan = volcan;
        this.visibilidad = new Visible(this);
    }
    @Override
    public void realizarAccionesTurno() {
        comunidad.aniadirGasVespeno(extraerGas());
        vida.pasarTurno();
    }

    public int extraerGas(){
        return volcan.extraer(20);
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
    public void construirSobreTipo(CeldaConMoho tipo) {throw new ConstruccionProhibida();}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {}
    @Override
    public void construirSobre(Celda celda) {
        celda.quiereConstruir(this);
    }
}
