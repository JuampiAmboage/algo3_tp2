package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase04 {
    /*
    //Verificar que extractor sin zánganos trabajando no genera gas. Verificar que con 1 saca
    //10, con 2 20, con 3 30 y que no puede recibir a un 4to zángano porque está lleno. Verificar
    //que el Asimilador recoge gas una vez construido según lo estipulado
    @Test
    public void unExtractorSinZanganosNoGeneraGas() {
        //Extractor e = new Extractor(new Volcan());
        assertEquals(0, e.extraerGas());
    }

    @Test
    public void unExtractorConUnZanganoGenera10DeGas() {
        //Extractor e = new Extractor(new Volcan());
        e.agregarZangano(new Zangano());
        assertEquals(10, e.extraerGas());
    }

    @Test
    public void unExtractorConDosZanganosGenera20DeGas() {
        //Extractor e = new Extractor(new Volcan());
        e.agregarZangano(new Zangano());
        e.agregarZangano(new Zangano());
        assertEquals(20, e.extraerGas());
    }

    @Test
    public void unExtractorConTresZanganosGenera30DeGas() {
        //Extractor e = new Extractor(new Volcan());
        e.agregarZangano(new Zangano());
        e.agregarZangano(new Zangano());
        e.agregarZangano(new Zangano());
        assertEquals(30, e.extraerGas());
    }

    @Test
    public void unExtractorNoPuedeRecibirUnCuartoZangano() {
        //Extractor e = new Extractor(new Volcan());
        e.agregarZangano(new Zangano());
        e.agregarZangano(new Zangano());
        e.agregarZangano(new Zangano());
        Executable task = () -> {
            e.agregarZangano(new Zangano());
        };
        assertThrows(RuntimeException.class, task);
    }
    @Test elAsimiladorSoloPuedeExtraerGasPasadoElTiempoEstipulado() {
        //Asimilador a = new Asimilador(6);
        a.pasarTurno();
        a.pasarTurno();
        a.pasarTurno();
        a.pasarTurno();
        a.pasarTurno();
        a.pasarTurno();
        assertEquals(20, a.extraerGas());
    }

     */
}
