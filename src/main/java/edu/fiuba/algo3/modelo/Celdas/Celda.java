package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Comunidad.Unidad;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.Recurso;

import java.util.ArrayList;

public class Celda {
    protected ArrayList<Celda> celdasAdyacentes;
    protected Unidad ocupante; // Uso Unidad porque según el caso de uso 16, un Zángano cuenta como ocupante
    protected TipoCelda tipo;
    protected Recurso recurso;

    static public boolean esCelda(Object objeto) {
        return objeto instanceof Celda;
    }

    public Celda(){
        this.recurso = new NoRecurso();
        this.tipo = new CeldaLibre(this);
    }

    public void ocupar(Unidad ocupante){
        this.ocupante = ocupante;
    }
    public Unidad desocupar(){
        Unidad u = this.ocupante;
        this.ocupante = null;
        return u;
    }

    public int cantidadAdyacentes() {
        return celdasAdyacentes.size();
    }
    public void setAdyacentes(ArrayList<Celda> adyacentes){
        celdasAdyacentes = adyacentes;
    }

    public boolean estaOcupada() {
        return this.ocupante != null;
    }
    public void pasarTurno(){
        if (this.ocupante != null) {
            this.ocupante.pasarTurno();
        }
        this.tipo.pasarTurno();
    }

    public void cambiarTipo(TipoCelda t) {
        //  delego para que cambiarTipo(Energizada) en una celda energizada aumente su energía
        this.tipo.cambiarTipo(t);
    }

    public boolean esMismoTipo(TipoCelda t) {
        return this.tipo.esMismoTipo(t);
    }
    public boolean tieneRecurso(Recurso r) {
        return this.recurso.esIgualA(r);
    }
    public int extraer(int cantidad) {
        return this.recurso.extraer(cantidad);
    }
}
