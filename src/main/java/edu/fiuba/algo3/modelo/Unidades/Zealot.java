package edu.fiuba.algo3.modelo.Unidades;

public class Zealot extends Unidad{
    public Zealot(){
        ataque = new AtacarTierra();
        superficie = "tierra";
        costoMinerales = 100;
        costoGas = 0;
        tiempo_constuccion = 4;
        danioTerrestre = 8;
        danioAereo = 0;
        rango_ataque = 4;
        vida = 100;
    }
}
