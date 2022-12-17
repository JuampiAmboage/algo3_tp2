package edu.fiuba.algo3.modelo.Celdas;

public class PuedeInfectar implements EstadoInfeccion{
    CeldaConMoho celdaConMohoCentral;

    public PuedeInfectar(CeldaConMoho celdaConMohoCentral){
        this.celdaConMohoCentral = celdaConMohoCentral;
    }
    public void infectar(){
        celdaConMohoCentral.expandir();
        celdaConMohoCentral.cambiarEstadoInfeccion(new InfeccionConcretada(celdaConMohoCentral));
    }

}
