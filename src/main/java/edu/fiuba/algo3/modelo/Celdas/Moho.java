package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Celda;

import java.util.ArrayList;

public class Moho {

    public Moho(){}

    public void infectarCeldas(ArrayList<Celda> adyacentes,int radio){
        Celda celdaAledania;
        for(int i=0; i<radio;i++){
            celdaAledania = adyacentes.get(i).infectarConMoho();
            celdaAledania.propagarFenonemos(radio-1);
        }
    }
}
