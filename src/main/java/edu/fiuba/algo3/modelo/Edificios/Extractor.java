package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.Vida;

import java.util.ArrayList;

public class Extractor extends Edificio implements Construible {

    private int cantidadMaximaDeTrabajadores = 3;
    private ArrayList<Zangano> trabajadores = new ArrayList<Zangano>(0);

    public Extractor(){
        this.tiempoDeConstruccion = 6;
        vida = new Vida(750);
    }

    @Override
    public void construirEn(Celda celda) {}

    public void pasarTurno(){
        vida.pasarTurno();
    }

    public void agregarTrabajador(Zangano trabajador) {
        if (this.trabajadores.size() != cantidadMaximaDeTrabajadores) {
            this.trabajadores.add(trabajador);
        } else {
            throw (new RuntimeException());
        }
    }

    public int extraerGas() {
        int gasExtraido = 0;

        if (this.trabajadores.size() == 0 ) {
            return gasExtraido;
        } else {
            for (Zangano trabajador :this.trabajadores) {
                gasExtraido += 10;
            }
        }

        return gasExtraido;

    }

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {}
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
