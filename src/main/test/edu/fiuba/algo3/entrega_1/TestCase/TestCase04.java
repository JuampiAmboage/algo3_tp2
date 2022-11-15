package edu.fiuba.algo3.entrega_1.TestCase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Recursos.*;
import edu.fiuba.algo3.modelo.Raza.Zangano;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase04 { //A todos les falta probar con test y terminados de construir

    //Verificar que extractor sin zánganos trabajando no genera gas. Verificar que con 1 saca
    //10, con 2 20, con 3 30 y que no puede recibir a un 4to zángano porque está lleno. Verificar
    //que el Asimilador recoge gas una vez construido según lo estipulado
    @Test
    public void unExtractorSinZanganosNoGeneraGas() {
        Extractor e = new Extractor();

        assertEquals(0, e.extraerGas());
    }

    @Test
    public void unExtractorConUnZanganoGenera10DeGas() {
        Volcan v = new Volcan();
        Extractor e = new Extractor();

        e.agregarTrabajador(new Zangano());

        assertEquals(10, e.extraerGas());
    }

    @Test
    public void unExtractorConDosZanganosGenera20DeGas() {
        Extractor e = new Extractor();

        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());

        assertEquals(20, e.extraerGas());
    }

    @Test
    public void unExtractorConTresZanganosGenera30DeGas() {
        Extractor e = new Extractor();
        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());
        assertEquals(30, e.extraerGas());
    }

    @Test
    public void unExtractorNoPuedeRecibirUnCuartoZangano() {
        Extractor e = new Extractor();
        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());
        Executable task = () -> {
            e.agregarTrabajador(new Zangano());
        };
        assertThrows(RuntimeException.class, task);
    }

    @Test
    public void elAsimiladorSoloPuedeExtraerGasPasadoElTiempoEstipulado() {
        Asimilador a = new Asimilador();

        assertEquals(20, a.extraerGas());
    }

}
