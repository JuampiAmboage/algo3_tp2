package edu.fiuba.algo3.modelo.Unidades;

public class Hidralisco extends UnidadAerea{
    public Hidralisco(){
        ataque = new AtacarTierraYAire();
        costoMinerales = 75;
        costoGas = 25;
        tiempo_constuccion = 4;
        danio = 10;
        danioAereo = 10;
        rango_ataque = 4;
        vida = 80;
    }
}
