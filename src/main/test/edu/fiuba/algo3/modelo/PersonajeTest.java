package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01SeCreaUnPersonajeYPorDefectoTieneElLapizHaciaArriba()
    {
        Personaje personaje = new Personaje();

        assertTrue( personaje.tieneLapizAbajo() ); /* inicialmente, tiene el lapiz abajo */
    }

    @Test
    public void test02SeLevantaYVuelveABajarElLapizConUnBloque(){
        Personaje personaje = new Personaje();
        BloqueMovimientoLevantar bloqueLevantar = new BloqueMovimientoLevantar();
        BloqueMovimientoBajar bloqueBajar = new BloqueMovimientoBajar();

        bloqueLevantar.ejecutar(personaje);

        /* ahora, el personaje, debería tener el lapiz levantado */
        assertFalse( personaje.tieneLapizAbajo() );

        bloqueBajar.ejecutar(personaje);

        /* subimos el lapiz con el bloque, debe dar true */
        assertTrue( personaje.tieneLapizAbajo() );
    }
}