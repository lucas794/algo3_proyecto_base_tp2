package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoArribaTest {
    @Test
    public void  test01seCambiaDePosicionUnaVezHaciaArriba(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoArriba movimientoArriba = new MovimientoArriba();

        movimientoArriba.mover(posicion);

        assertEquals(6, posicion.getVertical());
    }
}
