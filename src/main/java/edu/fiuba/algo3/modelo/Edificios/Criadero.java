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
    private int tiempoDeConstruccion;
    private int cantidadLarvasEnEspera;
    Evolucionador evolucionador;
    RangoExpansible rangoExpansible;
    public Criadero(){
        for(int i=0;i<3;i++)
            ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(new Larva());
        this.tiempoDeConstruccion = 4;
        vida = new Vida(500);
        evolucionador = new Evolucionador();
        this.cantidadLarvasEnEspera = 3;
        this.rangoExpansible = new RangoExpansible(5);
    }

    public void instanciacionInicial(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoExpansible.expandir(new CeldaConMoho(),posicion);
    }
    public void pasarTurno(){
        if(cantidadLarvasEnEspera < 3) {
            ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(new Larva());
            cantidadLarvasEnEspera++;
        }
        vida.pasarTurno();
    }

    public int obtenerCantidadDeLarvas(){
        return cantidadLarvasEnEspera;
    }

    public void engendrar() {
        cantidadLarvasEnEspera--;
        evolucionador.evolucionarUnidad(new Zangano(),new Larva());
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
