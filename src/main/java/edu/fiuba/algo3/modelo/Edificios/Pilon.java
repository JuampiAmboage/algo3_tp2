package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;
import edu.fiuba.algo3.modelo.Razas.UnidadConAmpliacionDeSuministro;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Pilon extends EdificioProtoss implements UnidadConAmpliacionDeSuministro {
    private RangoExpansible rangoExpansible;
    public Pilon(){
        super();
        this.tiempoConstruccion = 5;
        inicializaciones();
    }

    public void inicializaciones(){
        this.vida = new VidaConEscudo(300, 300);
        this.comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        this.suministro = 5;
        this.visibilidad = new Visible(this);
        this.rutaSprite = this.rutaSprite + "edificios/pilon.png";

    }
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        this.rangoExpansible = new RangoExpansible(posicion,3);
        this.energizarCeldasEnRango();
        this.aniadirSuministro();
    }
    @Override public void energizar(){}
    @Override
    public void desenergizar(){}
    public void aniadirSuministro(){
        comunidad.aniadirCapacidadSuministro(5);
    }
    private void energizarCeldasEnRango(){
        rangoExpansible.energizar();
    }

    public void disminuirVida(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
        if(vida.estaSinVida()) {
            this.desernegizar();
            this.comunidad.restarCapacidadSuministro(5);
            this.comunidad.quitarUnidad(this);
        }
    }
    public void desernegizar(){
        rangoExpansible.desenergizar();
    }
    public void pasarTurno(){
        this.estado.pasarTurno();
    }

    @Override
    public void realizarAccionesTurno() {
        vida.pasarTurno();
    }

    public int obtenerEscudo(){ return vida.getEscudoActual();}

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
    public void construirSobreTipo(CeldaConMoho tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {}
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
}
