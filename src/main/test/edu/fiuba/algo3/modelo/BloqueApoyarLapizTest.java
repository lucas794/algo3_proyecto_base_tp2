package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BloqueApoyarLapizTest {

    @Test
    public void test01SiSeEjecutaElBloqueApoyarLapizApoyaElLapizDeUnPersonaje() {
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        Personaje personaje = new Personaje();

        bloqueBajarLapiz.ejecutar(personaje);

        assertFalse(personaje.tieneLapizLevantado());
    }

    /*@Rule
    public ExceptedException thrown = ExpectedException.none();

    @Test
    public void test02SiSeEjecutaElBloqueApoyarLapizCuandoElLapizDeUnPersonajeEstaApoyadaLanzaUnaExcepcion() throws Exception{
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        Personaje personaje = new Personaje();

        bloqueBajarLapiz.ejecutar(personaje);

        thrown.expect(LapizEstaApoyadoExcepcion.class);
        bloqueBajarLapiz.ejecutar(personaje);
    }*/
}
