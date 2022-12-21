package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLleno;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorVacio;
import edu.fiuba.algo3.modelo.Opciones.DesemplearZangano;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Rango.RangoBusquedaYColocacion;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;
import edu.fiuba.algo3.modelo.Construccion.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.Vida;

import java.util.ArrayList;

public class Extractor extends Edificio {
    Volcan volcan;
    private int cantidadMaximaDeTrabajadores = 3;
    private ArrayList<Zangano> trabajadores = new ArrayList<Zangano>(0);
    private RangoBusquedaYColocacion rangoBusquedaYColocacion;

    public Extractor(Volcan volcan){
        this.tiempoConstruccion = 6;
        vida = new Vida(750);
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        this.volcan = volcan;
        this.visibilidad = new Visible(this);
        this.rutaSprite = this.rutaSprite + "edificios/extractor.png";
        this.opciones.add(new DesemplearZangano(obtenerDescripcion()));
    }
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoBusquedaYColocacion = new RangoBusquedaYColocacion(posicion,1);

    }
    public Extractor(Volcan volcan, int tiempoDeConstruccion) {
        this.tiempoConstruccion = tiempoDeConstruccion;
        this.vida = new Vida(750);
        this.volcan = volcan;
        this.visibilidad = new Visible(this);
    }
    public void pasarTurno(){
        this.estado.pasarTurno();
    }

    @Override
    public void realizarAccionesTurno() {
        vida.pasarTurno();
        comunidad.aniadirGasVespeno(extraerGas());
        for(Zangano zangano: trabajadores)
            zangano.pasarTurno();
    }

    public void agregarTrabajador(Zangano trabajador) {
        if (this.trabajadores.size() != cantidadMaximaDeTrabajadores) {
            this.trabajadores.add(trabajador);
        } else {
            throw (new ExtractorLleno());
        }
    }

    public void liberarTrabajador(){
        if(!trabajadores.isEmpty()){
            Zangano zanganoLiberado = this.trabajadores.get(0);
            rangoBusquedaYColocacion.colocarPorTierra(zanganoLiberado);
        }
        else{
            throw new ExtractorVacio();
        }
    }

    public int extraerGas() {
        int cantidadGasExtraido = 0;
        if (this.trabajadores.size() != 0 ) {
            for (Zangano trabajador :this.trabajadores) {
                cantidadGasExtraido += volcan.extraer(10);
            }
        }
        ComunidadZerg.obtenerInstanciaDeClase().aniadirGasVespeno(cantidadGasExtraido);
        return cantidadGasExtraido;
    }

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {}
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {throw new ConstruccionProhibida();}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {}
    @Override
    public void construirSobre(Celda celda) {
        celda.quiereConstruir(this);
        this.estado = new UnidadEnConstruccion(this);
    }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
