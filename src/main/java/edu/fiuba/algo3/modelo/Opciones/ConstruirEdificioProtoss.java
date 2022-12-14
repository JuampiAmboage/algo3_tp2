package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class ConstruirEdificioProtoss extends OpcionElegible{

    public ConstruirEdificioProtoss(String descripcion) {
        this.titulo = "Construir edificio protos";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    public void gestionarClick(Celda celda) {
        EdificioProtoss edificioAConstruir = obtenerEdificioAConstruir();
        ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda,edificioAConstruir);
        celda.instanciarUnidad(edificioAConstruir);
    }

    private EdificioProtoss obtenerEdificioAConstruir() {
        // TODO: Mostrar ventana con opciones.
        return edificioAConstruir;
    }
}
