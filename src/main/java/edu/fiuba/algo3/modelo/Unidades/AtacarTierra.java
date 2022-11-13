package edu.fiuba.algo3.modelo.Unidades;

public class AtacarTierra implements Atacar{
    public void atacar(Unidad unidadAtacable,int puntosAtaqueTierra, int puntosAtaqueAire){
        if(unidadAtacable.obtenerSuperficie().equals("tierra"))
            unidadAtacable.reducirVida(puntosAtaqueTierra);
        else {
            throw new IllegalArgumentException("No podes atacar a una unidad aerea");
        }
    }
}
