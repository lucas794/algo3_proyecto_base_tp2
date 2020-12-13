package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01SeCreaUnPersonajeYPorDefectoTieneElLapizHaciaArriba()
    {
        Personaje personaje = new Personaje();

        assertTrue( personaje.tieneLapizLevantado() ); /* inicialmente, tiene el lapiz levantado */
    }

    @Test
    public void test02SeLevantaYVuelveABajarElLapizConUnBloque(){
        Personaje personaje = new Personaje();
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();

        bloqueBajarLapiz.ejecutar(personaje);

        /* ahora, el personaje, debería tener el lapiz apoyado */
        assertFalse( personaje.tieneLapizLevantado() );

        bloqueLevantarLapiz.ejecutar(personaje);

        /* subimos el lapiz con el bloque, debe dar true */
        assertTrue( personaje.tieneLapizLevantado() );
    }
}