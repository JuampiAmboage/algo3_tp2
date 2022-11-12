package edu.fiuba.algo3.modelo.Unidades;

public class Dragon extends UnidadAerea{

    public Dragon() {
        ataque = new AtacarTierraYAire();
        costoMinerales = 125;
        costoGas = 50;
        tiempo_constuccion = 6;
        danio = 20;
        danioAereo = 20;
        rango_ataque = 4;
        vida = 100;
    }
}
