package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;

public interface Construible {
    void construirSobreRecurso(NoRecurso tipoRecurso);
    void construirSobreRecurso(NodoMineral tipoRecurso);
    void construirSobreRecurso(Volcan tipoRecurso);
    void construirSobreTipo(CeldaConMoho tipo);
    void construirSobreTipo(CeldaEnergizada tipo);
    void construirSobreTipo(CeldaLibre tipo);
    void construirSobre(Celda celda);
}
