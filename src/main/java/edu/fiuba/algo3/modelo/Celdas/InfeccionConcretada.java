package edu.fiuba.algo3.modelo.Celdas;

public class InfeccionConcretada implements EstadoInfeccion{
    CeldaConMoho celdaConMohoCentral;

    public InfeccionConcretada(CeldaConMoho celdaConMohoCentral){
        this.celdaConMohoCentral = celdaConMohoCentral;
    }
    public void infectar(){}
}
