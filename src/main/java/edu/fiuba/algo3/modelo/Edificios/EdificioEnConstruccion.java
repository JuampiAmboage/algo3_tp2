package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.ComunidadNueva.Comunidad;

public class EdificioEnConstruccion {
    int turnosNecesariosParaConstruir;
    int turnosTranscurridos;

    Comunidad comunidad;
    Edificio futuroEdificio;

    public EdificioEnConstruccion(Edificio edificioAConstruir,Comunidad comunidadQueConstruye){
        futuroEdificio = edificioAConstruir;
        comunidad = comunidadQueConstruye;
        turnosNecesariosParaConstruir = edificioAConstruir.obtenerTiempoConstruccion();
        turnosTranscurridos = 0;
    }
    public void pasarTurno(){
        if(turnosTranscurridos < turnosNecesariosParaConstruir)
            turnosTranscurridos++;
        else{
            comunidad.finalizarConstruccionEdificio(futuroEdificio,this);
        }
    }
}
