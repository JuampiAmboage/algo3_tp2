package edu.fiuba.algo3.modelo.Unidades;

public class Mutalisco extends UnidadAerea{
    public Mutalisco(){
        ataque = new AtacarTierraYAire();
        costoMinerales = 75;
        costoGas = 25;
        tiempo_constuccion = 4;
        danio = 9;
        danioAereo = 9;
        rango_ataque = 4;
        vida = 80;
    }
}
