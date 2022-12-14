package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierraYAire;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorTierra;
import edu.fiuba.algo3.modelo.Opciones.AtacarPorAire;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Dragon extends TropaTerrestre{

    public Dragon() {
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 125;
        costoEnGas = 50;
        tiempoConstruccion = 6;
        danioTerrestre = 20;
        danioAereo = 20;
        suministro = 3;
        edificioNecesario = new Acceso();
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        vida = new VidaConEscudo(100,80);
        opciones.add(new AtacarPorTierra(obtenerDescripcion()));
        opciones.add(new AtacarPorAire(obtenerDescripcion()));
        this.rutaSprite = this.rutaSprite + "tropas/protoss/dragon.png";
    }
    public void realizarAccionesTurno(){
        vida.pasarTurno();
        cantidadMovimientos = 0;

    }


    public void instanciacionInicial(Posicion posicionAColocar){
        posicion = posicionAColocar;
        rangoAtaque = new RangoAtaque(this,4,posicion);
    }

    public int obtenerEscudo(){return vida.getEscudoActual();}

    @Override
    public void mostrarDescripcion() {
        System.out.println("-Dragon-");
        System.out.println("Vehículo de alta gama. Da hasta cosa usarlo de lo caro que es. \n");
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
