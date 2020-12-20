package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {

    @Test
    public void test01SeCambiaDePosicionHaciendoUnMovimientoALaDerecha(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        movimientoDerecha.mover(posicion);

        assertEquals(6, posicion.getHorizontal());
    }

    @Test
    public void test02SeCambiaDePosicionHaciendoUnMovimientoALaIzquierda() {
        Posicion posicion = new Posicion(5, 5);

        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        movimientoIzquierda.mover(posicion);

        assertEquals(4, posicion.getHorizontal());
    }

    @Test
    public void test03SeCambiaDePosicionHaciendoUnMovimientoHaciaArriba(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoArriba movimientoArriba = new MovimientoArriba();

        movimientoArriba.mover(posicion);

        assertEquals(6, posicion.getVertical());
    }

    @Test
    public void test04SeCambiaDePosicionHaciendoUnMovimientoHaciaAbajo(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        movimientoAbajo.mover(posicion);

        assertEquals(4, posicion.getVertical());
    }



}
