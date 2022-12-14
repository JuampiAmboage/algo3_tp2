package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Razas.Tropas.Dragon;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Recursos.*;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase04 { //A todos les falta probar con test y terminados de construir
    @Test
    public void unExtractorSinZanganosNoGeneraGas() {
        Volcan volcan = new Volcan();
        Extractor e = new Extractor(volcan,0);

        assertEquals(0, e.extraerGas());
    }

    @Test
    public void unExtractorConUnZanganoGenera10DeGas() {
        Volcan v = new Volcan();
        Extractor e = new Extractor(v);

        e.agregarTrabajador(new Zangano());

        assertEquals(10, e.extraerGas());
    }

    @Test
    public void unExtractorConDosZanganosGenera20DeGas() {
        Volcan volcan =new Volcan();
        Extractor e = new Extractor(volcan);

        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());

        assertEquals(20, e.extraerGas());
    }

    @Test
    public void unExtractorConTresZanganosGenera30DeGas() {
        Volcan volcan = new Volcan();
        Extractor e = new Extractor(volcan);
        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());
        e.agregarTrabajador(new Zangano());
        assertEquals(30, e.extraerGas());
    }

    @Test
    public void unExtractorNoPuedeRecibirUnCuartoZangano() {
        Volcan volcan = new Volcan();
        Extractor e = new Extractor(volcan);
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
        Volcan volcan = new Volcan();
        Asimilador a = new Asimilador(volcan);
        assertEquals(20, a.extraerGas());
    }

    @Test
    public void siExtraigoMineralDeUnAsimiladorCincoVecesPuedoGenerarUnDragon(){
        Volcan volcan = new Volcan();
        Asimilador a = new Asimilador(volcan);
        a.construccionInstantanea();
        Dragon dragon = new Dragon();
        for(int i=0;i<3;i++)
            a.pasarTurno();
        assertDoesNotThrow(()->ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(dragon));
    }

}
