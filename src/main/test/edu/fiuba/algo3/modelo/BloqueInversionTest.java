package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueInversionTest {

    BloqueInversion bloqueInversion;
    Personaje personaje;
    Dibujo dibujo;
    List<Bloque> bloquesAEjecutar;
    Posicion posicionEsperada;

    @BeforeEach
    public void setUp(){
        personaje = new Personaje();
        dibujo = new Dibujo();
        bloquesAEjecutar = new ArrayList<>();
    }

    @Test
    public void test01SeMueveHaciaLaDerechaSeEsperaUnMovimientoOpuesto() {
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento( new MovimientoDerecha() );
        BloqueInversion bloqueInverso = new BloqueInversion( Arrays.asList(bloqueMovimiento) );

        bloqueInverso.ejecutar(personaje, dibujo);

        assertEquals(Arrays.asList(-1,0), personaje.obtenerPosicion() );
    }

    @Test
    public void test02SeMueveHaciaArribayDerechaSeEsperaMovimientoOpuesto()
    {
        BloqueMovimiento bloqueMovimientoArriba = new BloqueMovimiento( new MovimientoArriba() );
        BloqueMovimiento bloqueMovimientoDerecha = new BloqueMovimiento( new MovimientoDerecha() );

        BloqueInversion bloqueInverso = new BloqueInversion( Arrays.asList(bloqueMovimientoArriba, bloqueMovimientoDerecha) );

        bloqueInverso.ejecutar(personaje, dibujo);

        assertEquals(Arrays.asList(-1,-1), personaje.obtenerPosicion());
    }

    @Test
    public void test03SeLevantaElLapizYSeMueveHaciaAbajoSeEsperaMovimientoOpuesto() {
        // el orden opuesto a este test sería que baja el lapiz, y dibuja hacia arriba (posicion = (0,1))
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());

        BloqueInversion bloqueInverso = new BloqueInversion(Arrays.asList(bloqueLevantarLapiz, bloqueMoverAbajo));

        bloqueInverso.ejecutar(personaje, dibujo);

        assertEquals(Arrays.asList(0,1), personaje.obtenerPosicion());
    }

    @Test
    public void test04SeInvierteElMovimientoDeUnBloqueInverso() {
        // si se invierte un bloque inversion, DEBE anular la inversion y realizar el movimiento por default.
        BloqueMovimiento bloqueMovimientoArriba = new BloqueMovimiento( new MovimientoArriba() );
        BloqueInversion primerBloqueInversion = new BloqueInversion( Arrays.asList(bloqueMovimientoArriba) );
        BloqueInversion segundoBloqueInversion = new BloqueInversion( Arrays.asList(primerBloqueInversion) );

        segundoBloqueInversion.ejecutar(personaje, dibujo);

        assertEquals(Arrays.asList(0,1), personaje.obtenerPosicion());
    }
}
