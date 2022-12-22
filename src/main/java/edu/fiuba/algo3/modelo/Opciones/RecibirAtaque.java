package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;

public class RecibirAtaque extends OpcionElegible{
    public RecibirAtaque(String descripcion) {
        this.titulo = "Atacar";
    }

    public void gestionarClick(Celda celda, String opcionElejida){}

    @Override
    public void atacar(Celda celdaAAtacar){}
}
