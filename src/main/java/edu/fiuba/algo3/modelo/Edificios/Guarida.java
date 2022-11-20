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
import edu.fiuba.algo3.modelo.Unidades.Hidralisco;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.Vida;

public class Guarida extends Edificio implements Construible {
    static int conteoInstancias = 0;
    public static boolean existeAlMenosUnaInstancia(){
        return conteoInstancias > 0;
    }
    private final Salud vida = new Vida(1250);

    private Evolucionador evolucionador;
    public Guarida(){
        this.tiempoDeConstruccion = 12;
        conteoInstancias++;
        evolucionador = new Evolucionador();
    }
    public Guarida(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        conteoInstancias++;
    }

    public void construirEn(Celda celda) {
        celda.ocupar(this);
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

    public void generarHidralisco(){
        evolucionador.evolucionarLarva(new Hidralisco());
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
