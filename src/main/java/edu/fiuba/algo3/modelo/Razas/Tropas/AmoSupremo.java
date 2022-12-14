package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoDetector;
import edu.fiuba.algo3.modelo.Razas.UnidadConAmpliacionDeSuministro;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class AmoSupremo extends TropaAerea implements UnidadConAmpliacionDeSuministro {
    private RangoDetector rangoDetector;

    public AmoSupremo(){
        super();
        ataque = new AtacarAire();
        vida = new Vida(200);
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        costoEnMinerales = 50;
        costoEnGas = 0;
        tiempoConstruccion = 5;
        danioTerrestre = 0;
        danioAereo = 0;
        suministro = 0;
        edificioNecesario = new Criadero();
        opciones.add(new DetectarTropasInvisibles(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/zerg/amoSupremo.png";
        opciones.add(new MoverAerea("zerg"));
        opciones.add(new AtaqueTropaAerea("zerg"));

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
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        this.posicion = posicionALocalizar;
        this.rangoDetector = new RangoDetector(3,posicion);
        this.aplicarPesoEnSuministro();
        this.aniadirSuministro();
    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;
        cantidadAtaques = 0;
    }

    public void localicarZealots(){
        this.esUsable();
        rangoDetector.localizarZealots();
    }

    public void compararTropasDetectadasEntreTurnos(){
        rangoDetector.compararTropasDetectadasEntreTurnos();
    }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
