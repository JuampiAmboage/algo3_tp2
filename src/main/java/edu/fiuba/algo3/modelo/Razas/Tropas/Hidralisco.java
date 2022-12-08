package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Hidralisco extends TropaTerrestre{
    public Hidralisco() {
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 10;
        danioAereo = 10;
        suministro = 2;
        edificioNecesario = new Guarida();
        vida = new Vida(80);
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        comunidad.aniadirSuministro(suministro);
    }
    public void realizarAccionesTurno(){}

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
