package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;

public class Volcan extends Recurso {

    private String[] edificiosAceptados;

    public Volcan() {
        super();
        this.cantidad = 5000;
        this.edificiosAceptados = new String[2];

        this.edificiosAceptados[0] = "extractor";
        this.edificiosAceptados[1] = "asimilador";
    }
    @Override
    public int extraer(int c) {
        if (c <= this.cantidad) {
            this.cantidad -= c;
            return c;
        } else {
            // todo error
            return 0;
        }
    }

    @Override
    public boolean esIgualA(Object objeto) {
        return objeto instanceof Volcan;
    }

    public boolean ocupar_con(Edificio edificio) {
        if (edificiosAceptados[0] == edificio.nombre()) {
            return true;
        } else if (edificiosAceptados[1] == edificio.nombre()){
            return true;
        }else {
            return false;
        }
    }
}

