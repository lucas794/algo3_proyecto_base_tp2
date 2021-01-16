package edu.fiuba.algo3.modelo;

//No se me ocurre como testear sin la interfaz grafica y sin agregar getters

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    Dibujo sectorDibujo;
    Personaje personaje;
    List<Bloque> lista_de_bloques = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        sectorDibujo = new Dibujo();
        personaje = new Personaje();
    }

    @Test
    public void test01ElDibujoIniciaVacio()
    {
        List<Linea> lineas = new ArrayList<>(); // lista de lineas vacia, por ende debería dar true.

        assertEquals( lineas, sectorDibujo.obtenerSectorDibujado() );
    }

    @Test
    public void test02MovimientoHaciaDerechaNoDebeDibujarPeroSiCambiarSuUbicacion()
    {
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento( new MovimientoDerecha() );

        bloqueMovimiento.ejecutar( personaje, sectorDibujo );

        Posicion posicionEsperada = new Posicion(1,0 );

        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );

        List<Linea> lineas = new ArrayList<>(); // lista de lineas vacia, se movió hacia la derecha, pero no dibujó.

        assertEquals( lineas, sectorDibujo.obtenerSectorDibujado() );
    }

    @Test
    public void test03SeBajaElLapizYSeDibuja1Vez()
    {
        lista_de_bloques.add( new BloqueBajarLapiz() );
        lista_de_bloques.add( new BloqueMovimiento( new MovimientoDerecha() ));

        // resumen, baja el lapiz, luego se mueve hacia la derecha (1,0) ese es el sector dibujado.

        for( Bloque bloque : lista_de_bloques)
        {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        /*
        Aquí lo que intenté fue comparar las líneas pero para comparar, lo único que se me ocurre es
        agregar un getter a la clase línea para ir comparando. Es un inicio creo yo, posiblemente requiera modificaciones.

        List<Linea> lineas_dibujadas = new ArrayList<>();
        Linea linea = new Linea( new Posicion(0,0) );
        linea.setPosFinal( new Posicion(1,0) ); // donde termina de dibujar supuestamente.
        lineas_dibujadas.add(linea);

        System.out.println( Arrays.toString(sectorDibujo.obtenerSectorDibujado()) );
        */
    }
}
