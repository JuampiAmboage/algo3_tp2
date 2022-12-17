package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Tropas.*;


public class ComunidadZerg extends Comunidad {
    private static ComunidadZerg comunidadZerg;

    private ComunidadZerg() {
        super();
    }

    @Override
    public void inicializarBase() {
        Criadero criaderoInicial = new Criadero();
        Mapa.getInstance().generarBase(criaderoInicial);
        unidades.add(criaderoInicial);
        criaderoInicial.construccionInstantanea();
    }
    public static ComunidadZerg obtenerInstanciaDeClase() {
        if (comunidadZerg == null)
            comunidadZerg = new ComunidadZerg();
        return comunidadZerg;
    }

    public void crearUnidadTerrestre(Criadero criadero, TropaTerrestre tropaAGenerar){
        criadero.engendrarPorTierra(tropaAGenerar);
    }
    public void crearUnidadAerea(Criadero criadero, TropaAerea tropaAGenerar){
        criadero.engendrarPorAire(tropaAGenerar);
    }

    public void construirEdificio(Celda celda, Zangano zanganoAEvolucionar, Edificio nuevoEdificio) {
        celda.quiereConstruir(nuevoEdificio);
        zanganoAEvolucionar.evolucionarAEdificio(nuevoEdificio);
        celda.ocuparPorTierra(nuevoEdificio);
    }

    public void mutar(Mutalisco mutaliscoAMutar, UnidadEvolucionada tropaPostMutacion){
        mutaliscoAMutar.mutar(tropaPostMutacion);
    }
}
