package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.ComunidadNueva.Comunidad;

public class EdificioEnConstruccion {
    int turnosNecesariosParaConstruir;
    int turnosTranscurridos;

    Edificio futuroEdificio;

    public EdificioEnConstruccion(Edificio edificioAConstruir){
        futuroEdificio = edificioAConstruir;
        turnosNecesariosParaConstruir = edificioAConstruir.obtenerTiempoConstruccion();
        turnosTranscurridos = 0;
    }
    public void pasarTurno(){
        if(turnosTranscurridos < turnosNecesariosParaConstruir)
            turnosTranscurridos++;
        else{
            Comunidad comunidad = Comunidad.getInstance();
            comunidad.finalizarConstruccionEdificio(futuroEdificio,this);
        }
    }
}
