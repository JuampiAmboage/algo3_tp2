package edu.fiuba.algo3.modelo.Unidades;

public class AtacarAire implements Atacar{
    @Override
    public void atacar(Unidad unidadAtacable, int puntosAtaqueTierra, int puntosAtaqueAire) {
        if (unidadAtacable.obtenerSuperficie().equals("Aire")){
            unidadAtacable.reducirVida(puntosAtaqueAire);
        }
        else{
            System.out.println("No podés atacar a una unidad en tierra.");
        }
    }
}
