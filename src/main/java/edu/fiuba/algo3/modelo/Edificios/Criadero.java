package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Excepciones.EdificioHabilitadorNoCreado;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Criadero extends Edificio {
    private int cantidadLarvasEnEspera;
    public Criadero(){
        super(4);
        this.vida = new Vida(500);
        this.cantidadLarvasEnEspera = 3;
        this.comunidad = ComunidadZerg.obtenerInstanciaDeClase();
    }
    public Criadero(int tiempoDeConstruccion) {
        super(tiempoDeConstruccion);
        this.vida = new Vida(500);
        this.cantidadLarvasEnEspera = 3;
    }

    @Override
    public void pasarTurno(){
        this.estado.pasarTurno();
    }
    @Override
    public void realizarAccionesTurno() {
        if(cantidadLarvasEnEspera < 3) {
            cantidadLarvasEnEspera++;
        }
        vida.pasarTurno();
    }
    public int obtenerCantidadDeLarvas(){
        return cantidadLarvasEnEspera;
    }

    public void engendrar(Tropa tipoUnidad) {
        this.estado.esUsable();
        if(tipoUnidad.existeEdificioNecesario()) {
            comunidad.agregarUnidad(tipoUnidad);
            cantidadLarvasEnEspera--;
        }
        else
            throw new EdificioHabilitadorNoCreado();
    }

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
    public void construirSobre(Celda celda) throws ConstruccionProhibida{
        celda.quiereConstruir(this);
    }
}
