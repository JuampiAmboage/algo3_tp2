package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Excepciones.MineralEnNodoAgotado;
import edu.fiuba.algo3.modelo.Opciones.ConstruirNexoMineral;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;

import java.util.ArrayList;

public class NodoMineral extends Recurso {
    public NodoMineral() {
        super();
        this.cantidad = 2000;
        this.rutaSprite = this.rutaSprite + "nodoMineral.png";
        this.activarOpciones();

    }
    @Override
    public int extraer(int c) {
        if (c <= this.cantidad) {
            this.cantidad -= c;
            return c;
        } else {
            throw new MineralEnNodoAgotado();
        }
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreRecurso(this);
    }

    public ArrayList<OpcionElegible> obtenerOpciones() { return opciones; }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public void activarOpciones(){
        this.opciones.add(new ConstruirNexoMineral(obtenerDescripcion()));
    }
    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
