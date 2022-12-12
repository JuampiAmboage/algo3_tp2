package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Asimilador extends EdificioProtoss {
    Volcan volcan;
    public Asimilador(Volcan volcan) {
        super();
        this.tiempoConstruccion = 6;
        this.vida = new VidaConEscudo(450, 450);
        this.comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        this.volcan = volcan;
        this.visibilidad = new Visible(this);
        this.rutaSprite = this.rutaSprite + "edificios/asimilador.png";
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

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public void mostrarDescripcion() {
        System.out.println("-Acceso-");
        System.out.println("Extrae gas de un volcán.");
        System.out.println("Extracción: 20 por turno. \n");
        System.out.println("Escudo actual: " + this.vida.getEscudoActual());
        System.out.println("Vida actual: "+ this.vida.getVidaActual());
    }
}
