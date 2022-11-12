package edu.fiuba.algo3.modelo.Unidades;

public class Zerling extends Unidad
{
    public Zerling(){
        ataque = new AtacarTierra();
        costoMinerales = 25;
        costoGas = 0;
        tiempo_constuccion = 2;
        danio = 4;
        rango_ataque = 1;
        vida = 35;
    }

}
