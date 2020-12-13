package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {

    @Test
    public void test01SeCambiaDePosicionHaciendoUnMovimientoALaDerecha(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        Posicion nuevaPosicion = posicion.desplazarPosicion(movimientoDerecha);

        assertEquals(6, nuevaPosicion.getHorizontal());

    }
    @Test
    public void test02SeCambiaDePosicionHaciendoUnMovimientoHaciaArriba(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoArriba movimientoArriba = new MovimientoArriba();

        Posicion nuevaPosicion = posicion.desplazarPosicion(movimientoArriba);

        assertEquals(6, nuevaPosicion.getVertical());
    }
}
