package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BloqueLevantarLapizTest {

    @Test
    public void test01SiSeEjecutaElBloqueLevantarLapizLevantaElLapizDeUnPersonaje() {
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        Personaje personaje = new Personaje();

        bloqueBajarLapiz.ejecutar(personaje, new Dibujo());
        bloqueLevantarLapiz.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.tieneLapizLevantado());
    }

}