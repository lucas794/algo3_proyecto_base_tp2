package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LapizApoyadoTest {

    @Test
    public void test01ElMetodopuedeDibujarDevuelveTrue() {
        LapizApoyado lapizApoyado = new LapizApoyado();

        assertTrue(lapizApoyado.puedeDibujar());
    }
}