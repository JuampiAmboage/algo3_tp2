package edu.fiuba.algo3.modelo.Unidades;
public class AtacarAire implements Atacar{
    @Override
    public void atacar(Unidad unidadAtacable, int puntosAtaqueTierra, int puntosAtaqueAire) {
        if (unidadAtacable.obtenerSuperficie().equals("aire")){
            unidadAtacable.daniar(puntosAtaqueAire);
        }
        else{
            throw new IllegalArgumentException("No podes atacar a una unidad en tierra");
        }
    }
}
