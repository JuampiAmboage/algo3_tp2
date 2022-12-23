package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Turno.CondicionTurno;
import edu.fiuba.algo3.modelo.Turno.EsperandoTurno;
import edu.fiuba.algo3.modelo.Turno.Jugando;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class Jugador {
    Partida partidaQueEstaJugando;
    private String nombre;
    private Comunidad comunidad;

    private CondicionTurno condicionTurno;

    public Jugador(String nombre, Comunidad comunidad) {
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.comunidad.agregarJugadorPropietario(this);
        this.comunidad.inicializarBase();
    }

    public void introducirEnPartida(Partida partidaQueEstaJugando){
        this.partidaQueEstaJugando = partidaQueEstaJugando;
    }

    public void iniciarTurno(){
        this.condicionTurno = new Jugando(this);
    }
    public void mandarAEspera(){
        this.condicionTurno = new EsperandoTurno(this);
    }
    public void terminarTurno(){
        this.mandarAEspera();
    }

    public void cambioCondicionTurno(){
        this.condicionTurno.cambioDeTurno();
    }

    public boolean esSuTurno(){
        return this.condicionTurno.estoyJugando();
    }

    public void notificarFinDePartida(){
        partidaQueEstaJugando.finDePartida();
    }

    public String obtenerNombre(){
        return nombre;
    }


}
