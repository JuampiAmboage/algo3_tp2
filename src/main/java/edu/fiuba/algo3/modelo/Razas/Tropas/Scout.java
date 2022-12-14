package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierraYAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorTierra;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorAire;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Scout extends TropaAerea{
    public Scout(){
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 300;
        costoEnGas = 150;
        tiempoConstruccion = 9;
        danioTerrestre = 8;
        danioAereo = 14;
        suministro = 4;
        vida = new VidaConEscudo(150,100);
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        edificioNecesario = new PuertoEstelar();
        opciones.add(new AtacarPorTierra(obtenerDescripcion()));
        opciones.add(new AtacarPorAire(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/protoss/scout.png";
    }
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,4,posicion);
    }
    public void realizarAccionesTurno(){vida.pasarTurno();
        cantidadMovimientos = 0;
    }
    public int obtenerEscudo(){return vida.getEscudoActual();}

    @Override
    public void mostrarDescripcion() {
        System.out.println("-Scout-");
        System.out.println("Nave muy peligrosa. Te cañonea 10 veces antes de que toques el piso. \n");
        System.out.println("Escudo actual: " + this.vida.getEscudoActual());
        System.out.println("Vida actual: "+ this.vida.getVidaActual());
        System.out.println("Daño aereo: "+ this.danioAereo);
        System.out.println("Danio terrestre:" + this.danioTerrestre);
    }
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }

}
