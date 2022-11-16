package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza.Zangano;
import edu.fiuba.algo3.modelo.vida.Vida;

import java.util.ArrayList;

public class Extractor extends Edificio {

    private int cantidadMaximaDeTrabajadores = 3;
    private ArrayList<Zangano> trabajadores;

    public Extractor(){
        this.nombre = "extractor";
        this.trabajadores = new ArrayList<Zangano>(0);
        this.tiempoDeConstruccion = 6;
        this.vida = new Vida(750);
    }
    @Override
    public void construirEn(Celda celda) {

    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
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
}
