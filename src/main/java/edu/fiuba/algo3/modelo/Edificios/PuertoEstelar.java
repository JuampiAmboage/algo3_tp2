package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class PuertoEstelar extends Edificio {
    private Edificio edificioNecesario;

    public PuertoEstelar(){
        this.tiempoConstruccion = 10;
        edificioNecesario = new Acceso();
        vida = new VidaConEscudo(600, 600);
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
    }

    public void construirEn(Celda celda) {
        celda.ocuparPorTierra(this);
    }

    public boolean existeEdificioNecesario() {
        return comunidad.existeUnidad(edificioNecesario);
    }

    public void pasarTurno(){
        this.estado.pasarTurno();
    }

    @Override
    public void realizarAccionesTurno() {
        vida.pasarTurno();
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
