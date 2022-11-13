package edu.fiuba.algo3.modelo.Unidades;

public class AtacarTierraYAire implements Atacar{
    @Override
    public void atacar(Unidad unidadAtacable, int puntosAtaqueTierra, int puntosAtaqueAire) {
        if(unidadAtacable.obtenerSuperficie().equals("Tierra")){
            unidadAtacable.reducirVida(puntosAtaqueTierra);
        }
        else{
            unidadAtacable.reducirVida(puntosAtaqueAire);
        }
    }
}
