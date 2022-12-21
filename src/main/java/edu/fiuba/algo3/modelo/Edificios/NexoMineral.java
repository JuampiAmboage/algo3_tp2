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

public class NexoMineral extends EdificioProtoss implements Construible{
    NodoMineral nodoMineral;

    public NexoMineral(NodoMineral nodoMineral){
        tiempoConstruccion = 4;
        this.costoEnMinerales = 50;
        vida = new VidaConEscudo(250,250);
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        this.nodoMineral = nodoMineral;
        this.visibilidad = new Visible(this);
        this.rutaSprite = this.rutaSprite + "edificios/nexoMineral.png";
        this.nombreUnidad = "Nexo mineral";

    }

    public int extraerMineral(){
        return nodoMineral.extraer(10);
    }
    @Override
    public void pasarTurno() {
        this.estado.pasarTurno();
    }

    @Override
    public void realizarAccionesTurno() {
        vida.pasarTurno();
        comunidad.aniadirMineral(extraerMineral());
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
    public void construirSobreTipo(CeldaConMoho tipo) {}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {}
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {}
    @Override
    public void construirSobre(Celda celda) throws ConstruccionProhibida{
        celda.quiereConstruir(this);
    }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    /*@Override
    public void mostrarDescripcion() {
        System.out.println("-NexoMineral-");
        System.out.println("Extra mineral de un nodo mineral.");
        System.out.println("Extracción: 20 por turno. \n");
        System.out.println("Escudo actual: " + this.vida.getEscudoActual());
        System.out.println("Vida actual: " + this.vida.getVidaActual());
    }*/
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }

}
