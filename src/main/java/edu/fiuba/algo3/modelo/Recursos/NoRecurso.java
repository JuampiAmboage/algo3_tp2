package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;

import java.util.ArrayList;

public class NoRecurso extends Recurso {
    public NoRecurso(){
        super();
        this.cantidad = 0;
    }

    @Override
    public int extraer(int cantidad) {
        // _todo error SIEMPRE
        return 0;
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreRecurso(this);
    }

    @Override
    public ArrayList<OpcionElegible> obtenerOpciones() { return null; }

    @Override
    public String obtenerSprite() { return null; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
    @Override
    public boolean existe(){
        return false;
    }

    @Override
    public void activarOpciones(){}
}
