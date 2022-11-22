package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Razas.Evolucionador;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Unidades.Zerling;
import edu.fiuba.algo3.modelo.vida.Vida;

public class ReservaDeReproduccion extends Edificio{
    Evolucionador evolucionador;

    public ReservaDeReproduccion(){
        tiempoDeConstruccion = 12;
        vida = new Vida(1000);
        evolucionador = new Evolucionador();
    }
    @Override
    public void pasarTurno(){
        vida.pasarTurno();
    }
    public void generarZerling(Larva larva){
        evolucionador.evolucionarUnidad(new Zerling(),larva);
    }

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {}
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {throw new ConstruccionProhibida();}
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

