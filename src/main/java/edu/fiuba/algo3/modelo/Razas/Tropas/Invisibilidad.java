package edu.fiuba.algo3.modelo.Razas.Tropas;

import java.util.ArrayList;

public class Invisibilidad {
    private ArrayList<Tropa> tropasQueMePuedenVer;
    public Invisibilidad(){
        tropasQueMePuedenVer = new ArrayList<Tropa>();
    }
    public void agregarTropaDetectora(Tropa nuevaTropa){
        tropasQueMePuedenVer.add(nuevaTropa);
    }
    public void quitarTropaDetectora(Tropa tropaMuerta){
        tropasQueMePuedenVer.remove(tropaMuerta);
    }
    public boolean soyVisiblePara(Tropa tropa){
        return tropasQueMePuedenVer.contains(tropa);
    }
}
