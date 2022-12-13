package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Excepciones.GasEnVolcanAgotado;
import edu.fiuba.algo3.modelo.Opciones.ConstruirAsimilador;
import edu.fiuba.algo3.modelo.Opciones.ConstruirExtractor;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import javafx.geometry.Pos;

import java.util.ArrayList;

public class Volcan extends Recurso {
    public Volcan() {
        super();
        this.cantidad = 5000;

        this.rutaSprite = this.rutaSprite + "volcan.png";

        this.opciones.add(new ConstruirAsimilador());
        this.opciones.add(new ConstruirExtractor());
    }
    @Override
    public int extraer(int c) {
        if (c <= this.cantidad) {
            this.cantidad -= c;
            return c;
        } else {
            throw new GasEnVolcanAgotado();
        }
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreRecurso(this);
    }

    @Override
    public ArrayList<OpcionElegible> obtenerOpciones() { return null; }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }
}

