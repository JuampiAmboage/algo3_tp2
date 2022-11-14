package edu.fiuba.algo3.modelo.Recursos;

public class NoRecurso extends Recurso {
    public NoRecurso(){
        super();
        this.cantidad = 0;
    }
    @Override
    public int extraer(int cantidad) {
        // todo error SIEMPRE
        return 0;
    }

    @Override
    public boolean esIgualA(Object objeto) {
        return objeto instanceof NoRecurso;
    }
}
