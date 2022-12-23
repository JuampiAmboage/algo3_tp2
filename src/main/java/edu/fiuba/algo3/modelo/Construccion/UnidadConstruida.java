package edu.fiuba.algo3.modelo.Construccion;

import edu.fiuba.algo3.modelo.Razas.Unidad;

public class UnidadConstruida implements EstadoConstruccion {
        private final Unidad unidadFormada;
        public UnidadConstruida(Unidad unidadFormada) {
            this.unidadFormada = unidadFormada;
        }
        @Override
        public void pasarTurno() {
            this.unidadFormada.realizarAccionesTurno();
        }
        @Override
        public void esUsable() {}
}
