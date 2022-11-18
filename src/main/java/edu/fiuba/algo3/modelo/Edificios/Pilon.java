package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Pilon extends Edificio implements Construible {

    RangoExpansible rango;

    Posicion posicionPilon;
    private final Salud vida = new VidaConEscudo(300, 300);

    public Pilon(){
        this.tiempoDeConstruccion = 5;
        rango = new RangoExpansible(3);
        energizarCeldasEnRango();
    }
    public Pilon(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }

    @Override
    public void construirEn(Celda celda) {}

    public void energizarCeldasEnRango(){
        rango.expandir(new CeldaEnergizada(),posicionPilon.obtenerPosicionX(), posicionPilon.obtenerPosicionY());
    }

    public void desernegizar(){
        rango.expandir(new CeldaLibre(),posicionPilon.obtenerPosicionX(), posicionPilon.obtenerPosicionY());
    }

    public boolean estaOperativo() {
        return this.tiempoDeConstruccion <= 0;
    }
    public void pasarTurno(){
        if(!this.estaOperativo())
            this.tiempoDeConstruccion--;
        else{
            vida.pasarTurno();
        }
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
}
