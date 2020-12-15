package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    Personaje personaje;

    @BeforeEach
    public void setUp() {
        personaje = new Personaje();
    }

    @Test
    public void test01SeCreaUnPersonajeYPorDefectoTieneElLapizHaciaArriba()
    {
        assertTrue( personaje.tieneLapizLevantado() ); /* inicialmente, tiene el lapiz levantado */
    }

    @Test
    public void test02SeLevantaYVuelveABajarElLapizConUnBloque(){
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();

        bloqueBajarLapiz.ejecutar(personaje);
        bloqueLevantarLapiz.ejecutar(personaje);

        /* subimos el lapiz con el bloque, debe dar true */
        assertTrue( personaje.tieneLapizLevantado() );
    }

    @Test
    public void test03SeCreaUnPersonajeYLaPosicionInicialEs0_0(){
        assertEquals( Arrays.asList(0,0), personaje.obtenerPosicion() );
    }

    @Test
    public void test04SeMueveUnPersonajeUnaPosicionALaDerecha(){
        BloqueMoverDerecha bloqueMoverDerecha = new BloqueMoverDerecha();
        bloqueMoverDerecha.ejecutar(personaje);

        assertEquals( Arrays.asList(1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test05SeMueveUnPersonajeTresPosicionesALaDerecha(){
        BloqueMoverDerecha bloqueMoverDerecha = new BloqueMoverDerecha();

        for(int i = 0; i < 3; i++) {
            bloqueMoverDerecha.ejecutar(personaje);
        }

        assertEquals( Arrays.asList(3, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test06SeMueveUnPersonajeUnaPosicionALaIzquierda(){
        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();
        bloqueMoverIzquierda.ejecutar(personaje);

        assertEquals( Arrays.asList(-1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test07SeMueveUnPersonajeTresPosicionesALaIzquierda(){
        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();

        for(int i = 0; i < 3; i++) {
            bloqueMoverIzquierda.ejecutar(personaje);
        }

        assertEquals( Arrays.asList(-3, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test08SeMueveUnPersonajeUnaPosicionArriba(){
        BloqueMoverArriba bloqueMoverArriba = new BloqueMoverArriba();
        bloqueMoverArriba.ejecutar(personaje);

        assertEquals( Arrays.asList(0, 1), personaje.obtenerPosicion() );
    }

    @Test
    public void test09SeMueveUnPersonajeTresPosicionesArriba(){
        BloqueMoverArriba bloqueMoverArriba = new BloqueMoverArriba();

        for(int i = 0; i < 3; i++) {
            bloqueMoverArriba.ejecutar(personaje);
        }

        assertEquals( Arrays.asList(0, 3), personaje.obtenerPosicion() );
    }

    @Test
    public void test10SeMueveUnPersonajeUnaPosicionAbajo(){
        BloqueMoverAbajo bloqueMoverAbajo = new BloqueMoverAbajo();
        bloqueMoverAbajo.ejecutar(personaje);

        assertEquals( Arrays.asList(0, -1), personaje.obtenerPosicion() );
    }

    @Test
    public void test09SeMueveUnPersonajeTresPosicionesAbajo(){
        BloqueMoverAbajo bloqueMoverAbajo = new BloqueMoverAbajo();

        for(int i = 0; i < 3; i++) {
            bloqueMoverAbajo.ejecutar(personaje);
        }

        assertEquals( Arrays.asList(0, -3), personaje.obtenerPosicion() );
    }


    @Test
    public void test10SeMueveElPersonajeParaArribaYAbajoDebeTerminarEn0_0() {
        BloqueMoverAbajo bloqueMoverAbajo = new BloqueMoverAbajo();
        BloqueMoverArriba bloqueMoverArriba = new BloqueMoverArriba();

        bloqueMoverAbajo.ejecutar(personaje);
        bloqueMoverArriba.ejecutar(personaje);

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test11SeMueveElPersonajeParaIzquierdaYDerechaDebeTerminarEn0_0() {
        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();
        BloqueMoverDerecha bloqueMoverDerecha = new BloqueMoverDerecha();

        bloqueMoverIzquierda.ejecutar(personaje);
        bloqueMoverDerecha.ejecutar(personaje);

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test12SeMueveElPersonajeHaciaDiferentesSentidos() {
        List<Bloque> listaBloquesDeMovimiento = new ArrayList<>();
        listaBloquesDeMovimiento.add(new BloqueMoverAbajo());   /* (0, -1) */
        listaBloquesDeMovimiento.add(new BloqueMoverAbajo());   /* (0, -2) */
        listaBloquesDeMovimiento.add(new BloqueMoverDerecha()); /* (1, -2) */
        listaBloquesDeMovimiento.add(new BloqueMoverArriba());  /* (1, -1) */

        List<List<Integer>> lista_posiciones_esperadas = new ArrayList<>();
        lista_posiciones_esperadas.add( Arrays.asList(0, -1) );
        lista_posiciones_esperadas.add( Arrays.asList(0, -2) );
        lista_posiciones_esperadas.add( Arrays.asList(1, -2) );
        lista_posiciones_esperadas.add( Arrays.asList(1, -1) );

        int i;
        for( i = 0; i < lista_posiciones_esperadas.size( ); i++ )
        {
            listaBloquesDeMovimiento.get(i).ejecutar(personaje);
            assertEquals(lista_posiciones_esperadas.get(i), personaje.obtenerPosicion() );
        }
    }
}