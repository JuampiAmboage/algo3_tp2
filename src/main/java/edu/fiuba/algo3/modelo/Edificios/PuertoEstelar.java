package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Excepciones.EdificioHabilitadorNoCreado;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class PuertoEstelar extends Edificio {

    // TODO: En la construccion enviar a la celda correspondiente el sprite de celda con puerto estelar
    private Edificio edificioNecesario;

    public PuertoEstelar(){
        super();
        this.tiempoConstruccion = 10;
        this.edificioNecesario = new Acceso();
        this.vida = new VidaConEscudo(600, 600);
        this.comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        this.visibilidad = new Visible(this);
    }

    public void construirEn(Celda celda) {
        celda.ocuparPorTierra(this);
    }

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
    public void construirSobreTipo(CeldaConMoho tipo) {throw new ConstruccionProhibida();}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        this.existeEdificioNecesario();
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
