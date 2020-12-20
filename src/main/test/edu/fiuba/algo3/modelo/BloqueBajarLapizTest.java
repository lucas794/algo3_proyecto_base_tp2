package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BloqueBajarLapizTest {

    @Test
    public void test01SiSeEjecutaElBloqueBajarLapizApoyaElLapizDeUnPersonaje() {
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        Personaje personaje = new Personaje();

        bloqueBajarLapiz.ejecutar(personaje);

        assertFalse(personaje.tieneLapizLevantado());
    }

}
