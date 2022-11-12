package edu.fiuba.algo3.modelo.Unidades;

public class AtacarTierra implements Atacar{
    public void atacar(Unidad unidadAtacable,int puntosAtaque){
        unidadAtacable.reducirVida(puntosAtaque);
    }
}
