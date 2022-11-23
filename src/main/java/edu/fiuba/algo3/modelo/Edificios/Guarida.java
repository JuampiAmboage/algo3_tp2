package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Razas.Evolucionador;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Razas.Tropas.Hidralisco;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Guarida extends Edificio {
    static int conteoInstancias = 0;
    public static boolean existeAlMenosUnaInstancia(){
        return conteoInstancias > 0;
    }

    private Evolucionador evolucionador;
    public Guarida(){
        costoEnGas = 100;
        costoEnMinerales = 200;
        this.tiempoConstruccion = 12;
        conteoInstancias++;
        vida = new Vida(1250);
        evolucionador = new Evolucionador();
    }
    public void pasarTurno(){
        vida.pasarTurno();
    }

    public void generarHidralisco(Larva larva){
        evolucionador.evolucionarUnidad(new Hidralisco(),larva);
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
    public void construirSobre(Celda celda) {
        celda.quiereConstruir(this);
    }
}
