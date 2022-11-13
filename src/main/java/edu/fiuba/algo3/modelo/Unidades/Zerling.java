package edu.fiuba.algo3.modelo.Unidades;

public class Zerling extends Unidad
{
    public Zerling(){
        ataque = new AtacarTierra();
        superficie = "tierra";
        costoMinerales = 25;
        costoGas = 0;
        tiempo_constuccion = 2;
        danioTerrestre = 4;
        danioAereo = 0;
        rango_ataque = 1;
        vida = 35;
    }

}
