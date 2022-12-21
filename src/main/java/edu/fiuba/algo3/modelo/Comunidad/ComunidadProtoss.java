package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zealot;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class ComunidadProtoss extends Comunidad{

    private static ComunidadProtoss comunidadProtoss;
    private ComunidadProtoss() {
        super();
    }

    @Override
    public void inicializarBase() {
        Pilon pilonInicial = new Pilon();
        Mapa.getInstance().generarBase(pilonInicial);
        unidades.add(pilonInicial);
        pilonInicial.construccionInstantanea();
    }

    public static ComunidadProtoss obtenerInstanciaDeClase(){
        if(comunidadProtoss == null)
            comunidadProtoss = new ComunidadProtoss();
        return comunidadProtoss;
    }

    public void construirEdificio(Celda celda, Edificio nuevoEdificio) {
        celda.estaOcupadaPorTierra();
        celda.quiereConstruir(nuevoEdificio);
        agregarUnidad(nuevoEdificio);
        celda.ocuparPorTierra(nuevoEdificio);
    }
}
