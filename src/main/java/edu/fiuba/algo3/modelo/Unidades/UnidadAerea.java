package edu.fiuba.algo3.modelo.Unidades;

public class UnidadAerea extends Unidad{
    protected int danioAereo;

    @Override
    public void atacar(Unidad unidadAtacable){
        if(unidadAtacable instanceof UnidadAerea)
            unidadAtacable.reducirVida(danioAereo);
        else
            unidadAtacable.reducirVida(danio);
    }
}
