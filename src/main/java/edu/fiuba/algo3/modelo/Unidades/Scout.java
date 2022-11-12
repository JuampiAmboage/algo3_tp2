package edu.fiuba.algo3.modelo.Unidades;

public class Scout extends UnidadAerea{
    public Scout(){
        ataque = new AtacarTierraYAire();
        costoMinerales = 300;
        costoGas = 150;
        tiempo_constuccion = 9;
        danio = 8;
        danioAereo = 14;
        rango_ataque = 4;
        vida = 100;
    }
}
