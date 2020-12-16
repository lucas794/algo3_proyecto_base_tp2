package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoDerechaTest {

    @Test
    public void test01seCambiaDePosicionUnaVezHaciaLaDerecha(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        Posicion nuevaPosicion = movimientoDerecha.mover(posicion);

        assertEquals(6, nuevaPosicion.getHorizontal());
    }
}
