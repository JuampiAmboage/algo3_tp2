package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ZanganoYaEmpleado extends RuntimeException{
    public ZanganoYaEmpleado() {
        super();
        App.lanzarWarning("Este ZAngano ya esta empleado en otra tarea");
    }

}
