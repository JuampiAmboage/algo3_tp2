package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Excepciones.EdificioHabilitadorNoCreado;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Espiral extends Edificio {

    private Edificio edificioNecesario;
    public Espiral(){
        this.tiempoConstruccion = 10;
        this.costoEnMinerales = 150;
        this.costoEnGas = 100;
        this.edificioNecesario = new Guarida();
        this.vida = new Vida(1300);
        this.comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        this.visibilidad = new Visible(this);
        this.rutaSprite = this.rutaSprite + "edificios/espiral.png";

    }
    public void construirEn(Celda celda) { celda.ocuparPorTierra(this);}

    public void existeEdificioNecesario() {
        if(!comunidad.existeUnidad(edificioNecesario)) {
            throw new EdificioHabilitadorNoCreado();
        }
    }

    public void pasarTurno(){
        this.estado.pasarTurno();
    }

    @Override
    public void realizarAccionesTurno() {
        vida.pasarTurno();
    }

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {this.existeEdificioNecesario();}
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {this.existeEdificioNecesario();}
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

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    /*@Override
    public void mostrarDescripcion() {
        System.out.println("-Espiral-");
        System.out.println("Permite engendrar: Mutalisco. \n");
        System.out.println("Vida actual: " + this.vida.getVidaActual());
    }*/

    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
