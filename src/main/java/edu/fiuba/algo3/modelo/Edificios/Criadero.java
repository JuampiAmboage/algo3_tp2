package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;
import edu.fiuba.algo3.modelo.Razas.Evolucionador;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Criadero extends Edificio {
    private int cantidadLarvasEnEspera;
    private final Evolucionador evolucionador;
    public Criadero(){
        super(4);
        this.vida = new Vida(500);
        this.evolucionador = new Evolucionador();
        this.cantidadLarvasEnEspera = 3;
    }
    public Criadero(int tiempoDeConstruccion) {
        super(tiempoDeConstruccion);
        this.vida = new Vida(500);
        this.evolucionador = new Evolucionador();
        this.cantidadLarvasEnEspera = 3;
    }

    @Override
    public void pasarTurno(){
        this.estado.pasarTurno();
    }
    @Override
    public void accionarTurno() {
        if(cantidadLarvasEnEspera < 3) {
            cantidadLarvasEnEspera++;
        }
        vida.pasarTurno();
    }
    public int obtenerCantidadDeLarvas(){
        return cantidadLarvasEnEspera;
    }

    public void engendrar() {
        this.estado.esUsable();
        cantidadLarvasEnEspera--;
        //evolucionador.evolucionarUnidad(new Zangano(),new Larva());
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
