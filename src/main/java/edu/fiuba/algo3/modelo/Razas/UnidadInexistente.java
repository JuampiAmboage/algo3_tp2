package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Excepciones.NoExisteEstaUnidad;

public class UnidadInexistente extends Unidad{

    public UnidadInexistente(){}

    @Override
    public boolean existe(){
        return false;
    }

    public void realizarAccionesTurno(){
        throw new NoExisteEstaUnidad();
    }

    public String obtenerSprite(){
        throw new NoExisteEstaUnidad();
    }

    @Override
    public String obtenerDescripcion() {
        return null;
    }

    public void mostrarDescripcion(){}

}
