package edu.fiuba.algo3.modelo.Unidades;

public class Scout extends Unidad {
    public Scout(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoMinerales = 300;
        costoGas = 150;
        tiempo_constuccion = 9;
        danioTerrestre = 8;
        danioAereo = 14;
        rango_ataque = 4;
        vida = 100;
    }
}