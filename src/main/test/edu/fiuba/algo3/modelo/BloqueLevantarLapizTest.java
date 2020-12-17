package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BloqueLevantarLapizTest {

    @Test
    public void test01SiSeEjecutaElBloqueLevantarLapizLevantaElLapizDeUnPersonaje() {
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        Personaje personaje = new Personaje();

        bloqueBajarLapiz.ejecutar(personaje);
        bloqueLevantarLapiz.ejecutar(personaje);

        assertTrue(personaje.tieneLapizLevantado());
    }

    /*@Rule
    public ExceptedException thrown = ExpectedException.none();

    @Test
    public void test02SiSeEjecutaElBloqueLevantarLapizCuandoElLapizDeUnPersonajeEstaLevantadoLanzaUnaExcepcion() throws Exception{
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLa
        Personaje personaje = new Personaje();

        thrown.expect(LapizEstaLevantandoExcepcion.class);
        bloqueLevantarLapiz.ejecutar(personaje);
    }*/
}

