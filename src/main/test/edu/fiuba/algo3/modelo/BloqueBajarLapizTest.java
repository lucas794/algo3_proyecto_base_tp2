package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BloqueBajarLapizTest {

    @Test
    public void test01SiSeEjecutaBloqueBajarLapizElPersonajePuedeDibujarEnSectorDibujo() {
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        Personaje personaje = new Personaje();
        Dibujo sectorDibujo = new Dibujo();
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        bloqueBajarLapiz.ejecutar(personaje, sectorDibujo);

        personaje.mover(movimientoArriba, sectorDibujo);

        assertEquals( 1, sectorDibujo.obtenerSectorDibujado().size() );
    }

}
