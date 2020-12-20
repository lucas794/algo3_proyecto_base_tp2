package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoAbajoTest {

    @Test
    public void test01seCambiaDePosicionUnaVezHaciaAbajo(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        movimientoAbajo.mover(posicion);

        assertEquals(4, posicion.getVertical());

    }

    @Test
    public void test02SeCambiaDePosicionDosVecesHaciaAbajo(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        movimientoAbajo.mover(posicion);

        movimientoAbajo.mover(posicion);

        assertEquals(3, posicion.getVertical());

    }

}
