package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Acceso extends Edificio implements Construible {
    static int conteoInstancias = 0;
    public static boolean existeAlMenosUnaInstancia(){
        return conteoInstancias > 0;
    }
    private Salud vida;
    public Acceso(){
        this.tiempoDeConstruccion = 8;
        conteoInstancias++;
        vida = new VidaConEscudo(500, 500);
    }

    public void pasarTurno(){
        vida.pasarTurno();
    }

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {throw  new ConstruccionProhibida();}
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
