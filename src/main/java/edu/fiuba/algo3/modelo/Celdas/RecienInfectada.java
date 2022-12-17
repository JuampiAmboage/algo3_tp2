package edu.fiuba.algo3.modelo.Celdas;

public class RecienInfectada implements EstadoInfeccion{
    CeldaConMoho celdaConMohoCentral;

    public RecienInfectada(CeldaConMoho celdaConMohoCentral){
        this.celdaConMohoCentral = celdaConMohoCentral;
    }
    public void infectar(){
        celdaConMohoCentral.cambiarEstadoInfeccion(new PuedeInfectar(celdaConMohoCentral));
    }
}
