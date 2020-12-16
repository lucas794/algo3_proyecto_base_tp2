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
    public void test02SeCambiaDePosicionHaciendoUnMovimientoALaIzquierda() {
        Posicion posicion = new Posicion(5, 5);

        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        Posicion nuevaPosicion = posicion.desplazarPosicion(movimientoIzquierda);

        assertEquals(4, nuevaPosicion.getHorizontal());
    }

    @Test
    public void test03SeCambiaDePosicionHaciendoUnMovimientoHaciaArriba(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoArriba movimientoArriba = new MovimientoArriba();

        Posicion nuevaPosicion = posicion.desplazarPosicion(movimientoArriba);

        assertEquals(6, nuevaPosicion.getVertical());
    }

    @Test
    public void test04SeCambiaDePosicionHaciendoUnMovimientoHaciaAbajo(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        Posicion nuevaPosicion = posicion.desplazarPosicion(movimientoAbajo);

        assertEquals(4, nuevaPosicion.getVertical());
    }



}
