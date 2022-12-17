package edu.fiuba.algo3.modelo.Celdas;

public class PuedeInfectar implements EstadoInfeccion{
    private CeldaConMoho celdaConMohoCentral;
    private int delayExpansion;

    public PuedeInfectar(CeldaConMoho celdaConMohoCentral){
        this.celdaConMohoCentral = celdaConMohoCentral;
        delayExpansion = 1;
    }
    public void infectar(){
        if(delayExpansion == 0) {
            celdaConMohoCentral.expandir();
            celdaConMohoCentral.cambiarEstadoInfeccion(new InfeccionConcretada(celdaConMohoCentral));
        }
        else
            delayExpansion--;
    }

}
