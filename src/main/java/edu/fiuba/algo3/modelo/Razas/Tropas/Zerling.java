package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierra;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaAbajo;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaArriba;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaDerecha;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaIzquierda;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Zerling extends TropaTerrestre {
    public Zerling(){
        super();
        ataque = new AtacarTierra();
        costoEnMinerales = 25;
        costoEnGas = 0;
        tiempoConstruccion = 2;
        danioTerrestre = 4;
        danioAereo = 0;
        suministro = 1;
        vida = new Vida(35);
        edificioNecesario = new ReservaDeReproduccion();
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        //opciones.add(new TropaTerrestreAtacaTierra(obtenerDescripcion()));

        this.rutaSprite = this.rutaSprite + "tropas/zerg/zerlilng.png";
        opciones.add(new MoverTerrestreHaciaArriba(obtenerDescripcion(),"zerg"));
        opciones.add(new MoverTerrestreHaciaAbajo(obtenerDescripcion(),"zerg"));
        opciones.add(new MoverTerrestreHaciaIzquierda(obtenerDescripcion(),"zerg"));
        opciones.add(new MoverTerrestreHaciaDerecha(obtenerDescripcion(),"zerg"));
    }

    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,1,posicion);

    }
    public void realizarAccionesTurno(){vida.pasarTurno();
        cantidadMovimientos = 0;
    }

    /*@Override
    public void mostrarDescripcion() {
        System.out.println("-Zerling-");
        System.out.println("Tropa terrestre con mucho amor propio. No se la deja facil a nadie. \n");
        System.out.println("Vida actual: "+ this.vida.getVidaActual());
        System.out.println("Daño aereo: No tiene ");
        System.out.println("Danio terrestre:" + this.danioTerrestre);
    }*/
    public String obtenerSprite() { return this.rutaSprite; }
    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
