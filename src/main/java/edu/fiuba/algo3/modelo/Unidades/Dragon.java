package edu.fiuba.algo3.modelo.Unidades;

public class Dragon extends Unidad {

    public Dragon() {
        ataque = new AtacarTierraYAire();
        costoMinerales = 125;
        costoGas = 50;
        tiempo_constuccion = 6;
        danioTerrestre = 20;
        danioAereo = 20;
        rango_ataque = 4;
        vida = 100;
    }
}
