package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.ComunidadNueva.Comunidad;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;
import edu.fiuba.algo3.modelo.Raza.Evolucionador;
import edu.fiuba.algo3.modelo.Raza.Larva;
import edu.fiuba.algo3.modelo.Raza.Zangano;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.Vida;
import java.util.ArrayList;
import java.lang.RuntimeException;

public class Criadero extends Edificio implements Construible {
    private int tiempoDeConstruccion = 3;

    private int cantidadLarvasEnEspera = 0;
    private final Salud vida = new Vida(500);
    Evolucionador evolucionador;
    RangoExpansible rangoExpansible;
    public Criadero(){
        ComunidadZerg comunidad = ComunidadZerg.getInstance();
        for(int i=0;i<3;i++)
            comunidad.agregarLarva();
        this.tiempoDeConstruccion = 4;
        this.rangoExpansible = new RangoExpansible(5);
        rangoExpansible.expandir(new CeldaConMoho(),posicion.obtenerPosicionX(),posicion.obtenerPosicionY());
    }

    public Criadero(int tiempoDeConstruccion) {
        /*viejo metodo this.larvas = new ArrayList<Larva>(cantidadMaxDeLarvas);
        for (int i = 0; i < 3; i++) {
            agregarLarvas();
        }*/
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }


    @Override
    public void construirEn(Celda celda) {
        //verificacion de que se puede construir en esa celda
        this.turnosPasadosParaConstruccion = 0;
    }


    public boolean estaOperativo() {
        return this.tiempoDeConstruccion <= 0;
    }
    public void pasarTurno(){
        if(!this.estaOperativo())
            this.tiempoDeConstruccion--;
        else{
            if(cantidadLarvasEnEspera < 3) {
                ComunidadZerg comunidadZerg = ComunidadZerg.getInstance();
                comunidadZerg.agregarLarva();
                cantidadLarvasEnEspera++;
            }
            vida.pasarTurno();
        }
        rangoExpansible.expandir(new CeldaConMoho(),posicion.obtenerPosicionX(),posicion.obtenerPosicionY());
    }

    public int cantidadDeLarvas(){
        return cantidadLarvasEnEspera;
    }

    public void engendrar() {
        if (this.estaOperativo()) {
            cantidadLarvasEnEspera--;
            evolucionador.evolucionarLarvaAZangano();
        }else{
            throw (new RuntimeException());
        }
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
