package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LapizLevantadoTest {

    @Test
    public void test01ElMetodoPuedeDibujarDevuelveFalse() {
        LapizLevantado lapizLevantado = new LapizLevantado();

        assertFalse(lapizLevantado.puedeDibujar());
    }
}