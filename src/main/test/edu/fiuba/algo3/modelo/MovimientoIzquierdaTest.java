package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoIzquierdaTest {
    @Test
    public void test01seCambiaDePosicionUnaVezHaciaLaIzquierda() {
        Posicion posicion = new Posicion(5, 5);

        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        Posicion nuevaPosicion = movimientoIzquierda.mover(posicion);

        assertEquals(4, nuevaPosicion.getHorizontal());
    }

}
