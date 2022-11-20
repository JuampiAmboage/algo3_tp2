package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Raza.Evolucionador;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Unidades.Mutalisco;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.Vida;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Espiral extends Edificio implements Construible {
    private final Salud vida = new Vida(1300);

    private Evolucionador evolucionador;
    public Espiral(){
        this.tiempoDeConstruccion = 10;
    }
    public Espiral(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }

    public void construirEn(Celda celda) {
        if (Guarida.existeAlMenosUnaInstancia()){
            celda.ocupar(this);
        }
        else{
            throw new RuntimeException("Requiere un acceso para ser construido.");
        }
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

    public void generarMutalisco(){
        evolucionador.evolucionarLarva(new Mutalisco());
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
