package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ExtractorLleno extends RuntimeException {
    public ExtractorLleno() {
        super();
        App.lanzarWarning("Este extractor no admite más zánganos ya que alcanzó el máximo.");
    }
}
