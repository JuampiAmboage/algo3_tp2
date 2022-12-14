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
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
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
    private ArrayList<Zangano> trabajadores;
    private RangoBusquedaYColocacion rangoBusquedaYColocacion;

    public Extractor(Volcan volcan){
        this.tiempoConstruccion = 6;
        this.costoEnMinerales = 100;
        this.trabajadores = new ArrayList<>();
        this.vida = new Vida(750);
        this.comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        this.volcan = volcan;
        this.visibilidad = new Visible(this);
        this.rutaSprite = this.rutaSprite + "edificios/extractor.png";
        this.opciones.add(new DesemplearZangano(obtenerDescripcion()));

    }
    @Override
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoBusquedaYColocacion = new RangoBusquedaYColocacion(posicion,1);

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
        this.esUsable();
        int cantidadMaximaDeTrabajadores = 3;
        if (this.trabajadores.size() <= cantidadMaximaDeTrabajadores) {
            this.trabajadores.add(trabajador);
        } else {
            throw (new ExtractorLleno());
        }
    }

    public void liberarTrabajador(){
        this.esUsable();
        if(!trabajadores.isEmpty()){
            Zangano zanganoLiberado = this.trabajadores.get(0);
            zanganoLiberado.liberarDeExtractor();
            rangoBusquedaYColocacion.colocarPorTierra(zanganoLiberado);
            trabajadores.remove(0);
        }
        else{
            throw new ExtractorVacio();
        }
    }

    public int extraerGas() {
        int cantidadGasExtraido = 0;
        if (!this.trabajadores.isEmpty()) {
            for (Zangano zangano : trabajadores)
                cantidadGasExtraido += volcan.extraer(10);
        }
        return cantidadGasExtraido;
    }

    @Override
    public void disminuirVida(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
        if(vida.estaSinVida()) {
            comunidad.restarPesoEnSuministro(suministro);
            comunidad.quitarUnidad(this);
            Mapa.getInstance().obtenerCelda(this.posicion).activarOpcionesRecurso();
            this.desaparecerUnidadDeCelda();
        }
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
    public void construirSobreTipo(CeldaConMoho tipo) {}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {throw new ConstruccionProhibida();}
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
