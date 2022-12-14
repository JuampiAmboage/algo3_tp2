package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Devorador;
import edu.fiuba.algo3.modelo.Razas.Tropas.Guardian;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;

public class Mutar extends OpcionElegible{
    public Mutar(String descripcion) {
        this.titulo = "Mutar";
        this.pertenceA = "zerg";
        this.textoBotones.add("Mutar a devorador");
        this.textoBotones.add("Mutar a guardian");
    }

    public void gestionarClick(Celda celda, String opcionElejida){
        Mutalisco mutalisco = (Mutalisco) celda.obtenerOcupanteAereo();
        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida))
                mutarADevorador(celda,mutalisco);
            else
                mutarAGuardian(celda,mutalisco);
        }
    }

    public void mutarADevorador(Celda celda,Mutalisco mutalisco){
        Devorador devorador = new Devorador();
        mutalisco.mutar(devorador);
        celda.instanciarUnidad(devorador);
    }

    public void mutarAGuardian(Celda celda,Mutalisco mutalisco) {
        Guardian guardian = new Guardian();
        mutalisco.mutar(guardian);
        celda.instanciarUnidad(guardian);
    }

}
