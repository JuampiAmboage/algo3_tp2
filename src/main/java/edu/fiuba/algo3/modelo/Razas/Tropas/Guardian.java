package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierra;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Guardian extends TropaAerea implements UnidadEvolucionada{
    public Guardian(){
        super();
        ataque = new AtacarTierra();
        costoEnMinerales = 50;
        costoEnGas = 100;
        tiempoConstruccion = 4;
        danioTerrestre = 25;
        danioAereo = 0;
        suministro = 0;
        vida = new Vida(100);
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
       //opciones.add(new TropaAereaAtacaTierra(obtenerDescripcion()));

        this.rutaSprite = this.rutaSprite + "tropas/zerg/guardian.png";
    }
    public void realizarAccionesTurno(){vida.pasarTurno();
        cantidadMovimientos = 0;
    }

    @Override
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,10,posicion);

    }

    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
