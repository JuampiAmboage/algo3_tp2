package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class EdificioHabilitadorNoCreado extends RuntimeException{
        public EdificioHabilitadorNoCreado() {
            super();
            App.lanzarWarning("El edificio que habilita a construir esta unidad no fue creado");
        }
}
