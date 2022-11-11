package edu.fiuba.algo3.modelo.Celdas;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;

public class CeldaLibre extends Celda{
    private Moho moho;
    private Energia energia;

    private ArrayList<CeldaLibre> celdasAdyacentesPropagables;

    public CeldaLibre(){
        super();
        moho = null;
        energia = null;
    }

    public void setCeldasAdyacentesPropagables(){
        for (int i=0; i<celdasAdyacentes.size();i++){
            Celda celdaAdyacenteActual = celdasAdyacentes.get(i);
            if(celdaAdyacenteActual instanceof CeldaLibre)
                celdasAdyacentesPropagables.add(celdaAdyacenteActual);
        }
    }

    //creacion del moho/energia
    public void infectarConMoho(){
        moho = new Moho();
    }

    //booleano para saber si hay moho/energia
    public void energizar(){
        if(!infectadaConMoho()){
            energia = new Energia();
        }
    }

    public boolean infectadaConMoho(){ return moho != null;}
    public boolean energizada(){return energia != null;}

    public void propagarFenomenos(){

    }
}
