package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BloqueLevantarLapizTest {

    @Test
    public void test01SiSeEjecutaBloqueLevantarLapizElSectorDibujoNoTieneLineasDibujadas() {
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        Personaje personaje = new Personaje();
        Dibujo sectorDibujo = new Dibujo();
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        bloqueLevantarLapiz.ejecutar(personaje, sectorDibujo);

        personaje.mover(movimientoArriba, sectorDibujo);

        assertEquals( 0, sectorDibujo.obtenerSectorDibujado().size() );
    }
}