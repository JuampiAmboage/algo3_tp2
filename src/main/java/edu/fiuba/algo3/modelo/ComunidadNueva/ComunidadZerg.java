package edu.fiuba.algo3.modelo.ComunidadNueva;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;


public class ComunidadZerg extends Comunidad {
    private static ComunidadZerg comunidadZerg;

    private ComunidadZerg() {
        super();
    }

    public static ComunidadZerg obtenerInstanciaDeClase(){
        if(comunidadZerg == null)
            comunidadZerg = new ComunidadZerg();
        return comunidadZerg;
    }

    private void existenciasIniciales() {
        Mapa mapa = Mapa.getInstance();
        for (int i = 0; i < 3; i++)
            agregarUnidad(new Larva());
        edificiosConstruidos.add(new Criadero());
    }

    public void quitarZangano(Zangano zangano) {
        zangano.revisarEstadoLaboral();
        unidades.remove(zangano);
    }

    public void darTrabajoAZangano(Zangano zangano, Extractor extractor){
        int iterador = 0;
        while (unidades.get(iterador) != zangano){
            iterador++;
        }
        zangano.asignarTrabajo(extractor);
    }

    public void construirEdificio(Edificio nuevoEdificio, Zangano zanganoQueVaAEvolucionar){
        administrarRecursos(nuevoEdificio.obtenerCostoGas(),nuevoEdificio.obtenerCostoMinerales());
        EdificioEnConstruccion construccion = new EdificioEnConstruccion(nuevoEdificio,this);
        edificiosEnConstruccion.add(construccion);
        quitarZangano(zanganoQueVaAEvolucionar);
    }
}
