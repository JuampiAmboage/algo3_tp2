package edu.fiuba.algo3.modelo.Unidades;

public class AtacarTierra implements Atacar{
    public void atacar(Unidad unidadAtacable,int puntosAtaqueTierra, int puntosAtaqueAire){
        if(unidadAtacable.obtenerSuperficie().equals("Tierra"))
            unidadAtacable.reducirVida(puntosAtaqueTierra);
        else
            System.out.println("No podes atacar a una unidad aerea.");
    }
}
