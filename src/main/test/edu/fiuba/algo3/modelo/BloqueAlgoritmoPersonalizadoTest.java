package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.BloqueAlgoritmoPersonalizado;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BloqueAlgoritmoPersonalizadoTest {
    /*
    DBAlgoritmoPersonalizados dbAlgoritmosPersonalizados;
    Dibujo dibujo;
    Personaje personaje;

    @BeforeEach
    void setUp() {
        dbAlgoritmosPersonalizados = new DBAlgoritmoPersonalizados();
        dibujo = new Dibujo();
        personaje = new Personaje();
    }

    @Test
    public void test01SeCreaUnAlgoritmoPersonalizadoALaDerechaySeLoGuarda()
    {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento( new MovimientoArriba() );
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento( new MovimientoDerecha() );

        BloqueAlgoritmoPersonalizado bloqueap = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados, Arrays.asList(bloqueMoverArriba, bloqueMoverDerecha), "test01");

        BloqueAlgoritmoPersonalizado bloqueapCarga = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados, "test01");

        bloqueapCarga.ejecutar(personaje, dibujo);

        Posicion posicionEsperada = new Posicion(1,1);

        assertEquals( posicionEsperada.obtenerCoordenadas() , personaje.obtenerPosicion() );
    }
    */
}