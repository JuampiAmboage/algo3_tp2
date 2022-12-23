package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Excepciones.SinLarvas;
import edu.fiuba.algo3.modelo.Opciones.Engendrar;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoBusquedaYColocacion;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Criadero extends Edificio {

    private int cantidadLarvasEnEspera;
    protected RangoExpansible rangoExpansible;

    private RangoBusquedaYColocacion rangoBusquedaYColocacion;
    public Criadero(){
        super();
        this.tiempoConstruccion = 4;
        this.costoEnMinerales = 200;
        this.inicializaciones();
    }
    public void inicializaciones(){
        this.vida = new Vida(500);
        this.cantidadLarvasEnEspera = 3;
        this.comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        this.visibilidad = new Visible(this);
        this.costoEnGas = 0;
        this.costoEnMinerales = 200;
        opciones.add(new Engendrar(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "edificios/criadero.png";
        this.nombreUnidad = "Criadero";

    }

    public void instanciacionesIniciales(Posicion posicionALocalizar){
        this.posicion = posicionALocalizar;
        this.aniadirSuministro();
        this.rangoExpansible = new RangoExpansible(posicion,1);
        this.rangoBusquedaYColocacion = new RangoBusquedaYColocacion(posicion,1);
        this.infectarCeldasEnRango();

    }
    private void infectarCeldasEnRango(){
        rangoExpansible.expandirMoho();
    }
    public void aniadirSuministro(){
        comunidad.aniadirCapacidadSuministro(5);
    }

    public void disminuirVida(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
        if(vida.estaSinVida()) {
            comunidad.restarCapacidadSuministro(5);
            comunidad.quitarUnidad(this);
        }
    }
    @Override
    public void pasarTurno(){
        this.estado.pasarTurno();
    }

    public void hayLarvasRestantes(){
        if(cantidadLarvasEnEspera == 0){
            throw new SinLarvas();
        }
    }
    @Override
    public void realizarAccionesTurno() {
        if(cantidadLarvasEnEspera < 3) {
            cantidadLarvasEnEspera++;
        }
        vida.pasarTurno();
    }
    public int obtenerCantidadDeLarvas(){
        return cantidadLarvasEnEspera;
    }

    public void engendrar(Tropa tipoUnidad) {
        this.estado.esUsable();
        this.hayLarvasRestantes();
        tipoUnidad.existeEdificioNecesario();
        comunidad.agregarUnidad(tipoUnidad);
        cantidadLarvasEnEspera--;
    }

    public void engendrarPorTierra(TropaTerrestre tipoUnidad){
        engendrar(tipoUnidad);
        rangoBusquedaYColocacion.colocarPorTierra(tipoUnidad);
        evaluarExitoEnColocacionDeTropaEngendrada(tipoUnidad);
    }

    public void engendrarPorAire(TropaAerea tipoUnidad){
        engendrar(tipoUnidad);
        rangoBusquedaYColocacion.colocarPorAire(tipoUnidad);
        evaluarExitoEnColocacionDeTropaEngendrada(tipoUnidad);
    }

    public void evaluarExitoEnColocacionDeTropaEngendrada(Tropa tipoUnidad){
        if(!rangoBusquedaYColocacion.colocacionExitosa())
            tipoUnidad.deshacerCambiosEnComunidad();
    }
    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {}
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobre(Celda celda) throws ConstruccionProhibida{
        celda.quiereConstruir(this);
    }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    public String obtenerDescripcion(){
        String descripcion = "";
        return descripcion;
    }
}
