package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.UnidadEvolucionada;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;


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
    }
    public static ComunidadZerg obtenerInstanciaDeClase() {
        if (comunidadZerg == null)
            comunidadZerg = new ComunidadZerg();
        return comunidadZerg;
    }

    public void crearUnidad(Criadero criaderoQueGenera, Tropa unidadAGenerar) {
        criaderoQueGenera.engendrar(unidadAGenerar);
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
