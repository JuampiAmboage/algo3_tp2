package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Tropas.Devorador;
import edu.fiuba.algo3.modelo.Razas.Tropas.Guardian;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.UnidadEvolucionada;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class Mutar extends OpcionElegible{
    public Mutar(String descripcion) {
        this.titulo = "Mutar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Mutar a devorador");
        this.textoBotones.add("Mutar a guardian");
    }

    public void gestionarClick(Celda celda, String opcionElejida){
        Mutalisco mutalisco = (Mutalisco) celda.obtenerOcupanteTerrestre();
        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida))
                mutarADevorador(celda,mutalisco);
            else
                mutarAGuardian(celda,mutalisco);
        }
    }

    public void mutarADevorador(Celda celda,Mutalisco mutalisco){
        Devorador devorador = new Devorador();
        mutalisco.mutar((UnidadEvolucionada) devorador);
        celda.instanciarUnidad(devorador);
    }

    public void mutarAGuardian(Celda celda,Mutalisco mutalisco) {
        Guardian guardian = new Guardian();
        mutalisco.mutar(guardian);
        celda.instanciarUnidad(guardian);
    }
}
