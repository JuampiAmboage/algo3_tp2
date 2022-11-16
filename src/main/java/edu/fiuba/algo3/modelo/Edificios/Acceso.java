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
    private final Salud vida = new VidaConEscudo(500, 500);
    public Acceso(){
        this.tiempoDeConstruccion = 8;
        conteoInstancias++;
    }
    public Acceso(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        conteoInstancias++;
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
