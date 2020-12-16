package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoAbajoTest {

    @Test
    public void test01seCambiaDePosicionUnaVezHaciaAbajo(){
        Posicion posicion = new Posicion(5, 5);

        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        Posicion nuevaPosicion = movimientoAbajo.mover(posicion);

        assertEquals(4, nuevaPosicion.getVertical());

    }

    @Test
    public void test02SeCambiaDePosicionDosVecesHaciaAbajo(){
        Posicion primeraPos = new Posicion(5, 5);

        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        Posicion segundaPos = movimientoAbajo.mover(primeraPos);

        Posicion terceraPos = movimientoAbajo.mover(segundaPos);

        assertEquals(3, terceraPos.getVertical());

    }

}
