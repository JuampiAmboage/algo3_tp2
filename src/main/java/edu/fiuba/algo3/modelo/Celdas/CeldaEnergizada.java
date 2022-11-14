package edu.fiuba.algo3.modelo.Celdas;

public class CeldaEnergizada extends TipoCelda{
    private int energia = 0;
    public CeldaEnergizada(Celda celda) {
        super(celda);
        this.energia++;
    }

    @Override
    void pasarTurno() {

    }

    @Override
    boolean esMismoTipo(Object objeto) {
        return false;
    }

    @Override
    boolean estaOcupada() {
        return false;
    }

    @Override
    void cambiarTipo(TipoCelda t) {
        if (t instanceof CeldaEnergizada) {
            energia ++;
        } else {
            this.celda.tipo = t;
        }
    }

    public void expandir(int radio) {
        // Haciendo mapa un singleton para tenerlo de referencia
        //Mapa.getCeldasEnRadio(this.celda, radio)
        //celdas.forEach(cambiarTipo(energizada))
    }
}
