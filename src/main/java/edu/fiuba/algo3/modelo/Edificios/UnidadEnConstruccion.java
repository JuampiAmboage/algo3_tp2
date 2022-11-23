package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Razas.Raza;

public class UnidadEnConstruccion {
    int turnosNecesariosParaConstruir;
    int turnosTranscurridos;

    Comunidad comunidad;
    Raza futuraUnidad;

    public UnidadEnConstruccion(Raza unidadAConstruir, Comunidad comunidadQueConstruye){
        futuraUnidad = unidadAConstruir;
        comunidad = comunidadQueConstruye;
        turnosNecesariosParaConstruir = futuraUnidad.obtenerTiempoConstruccion();
        turnosTranscurridos = 0;
    }
    public void pasarTurno(){
        if(++turnosTranscurridos == turnosNecesariosParaConstruir)
            comunidad.finalizarUnidadEnConstruccion(futuraUnidad,this);
    }
}
