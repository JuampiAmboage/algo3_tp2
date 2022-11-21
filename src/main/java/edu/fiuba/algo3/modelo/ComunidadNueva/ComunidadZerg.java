package edu.fiuba.algo3.modelo.ComunidadNueva;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import edu.fiuba.algo3.modelo.Unidades.Tropa;

import java.util.ArrayList;

public class ComunidadZerg extends Comunidad {
    private static ComunidadZerg comunidadZerg;
    private ArrayList<Larva> larvas;
    private ArrayList<Zangano> zanganos;
    private ComunidadZerg() {
        super();
        larvas = new ArrayList<Larva>();
        zanganos = new ArrayList<Zangano>();
    }

    public static ComunidadZerg obtenerInstanciaDeClase(){
        if(comunidadZerg == null)
            comunidadZerg = new ComunidadZerg();
        return comunidadZerg;
    }

    private void existenciasIniciales() {
        Mapa mapa = Mapa.getInstance();
        for (int i = 0; i < 3; i++)
            agregarLarva();
        edificiosConstruidos.add(new Criadero());
    }

    public void agregarLarva() {
        larvas.add(new Larva());
    }

    private void quitarLarva() {
        larvas.remove(0);
    }

    public void agregarZangano() {
        Zangano nuevoZangano = new Zangano();
        administrarRecursos(nuevoZangano.obtenerCostoGas(), nuevoZangano.obtenerCostoMinerales());
        zanganos.add(nuevoZangano);
        quitarLarva();
    }

    private void quitarZangano() {
        zanganos.remove(0);
    }

    @Override
    public void construirEdificio(Edificio nuevoEdificio){
        administrarRecursos(nuevoEdificio.obtenerCostoGas(),nuevoEdificio.obtenerCostoMinerales());
        EdificioEnConstruccion construccion = new EdificioEnConstruccion(nuevoEdificio,this);
        edificiosEnConstruccion.add(construccion);
        quitarZangano();
    }
    public void mutarTropa(Tropa tropaMutable, Tropa tropaMutada){
        administrarRecursos(tropaMutable.obtenerCostoGas(),tropaMutable.obtenerCostoMinerales());
        tropas.remove(tropaMutable);
        tropas.add(tropaMutada);
    }
}
