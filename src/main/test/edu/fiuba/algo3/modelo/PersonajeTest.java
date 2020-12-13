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

        /* ahora, el personaje, debería tener el lapiz apoyado */
        assertFalse( personaje.tieneLapizLevantado() );

        bloqueLevantarLapiz.ejecutar(personaje);

        /* subimos el lapiz con el bloque, debe dar true */
        assertTrue( personaje.tieneLapizLevantado() );
    }

    @Test
    public void test03SeCreaUnPersonajeYSeLoMueveEnTodasLasDirecciones() {
        /* el personaje, inicialmente, está en el (0,0) */
        assertEquals( Arrays.asList(0,0), personaje.obtenerPosicion() );

        BloqueMoverDerecha bloqueMoverDerecha = new BloqueMoverDerecha();
        bloqueMoverDerecha.ejecutar(personaje);

        /* si el personaje se mueve hacia la derecha, está en el punto (1,0) */
        assertEquals( Arrays.asList(1, 0), personaje.obtenerPosicion() );

        BloqueMoverAbajo bloqueMoverAbajo = new BloqueMoverAbajo();
        bloqueMoverAbajo.ejecutar(personaje);

        /* si el personaje se mueve hacia abajo estando en (1,0) , debe ir a (1,-1) */
        assertEquals( Arrays.asList(1, -1), personaje.obtenerPosicion() );

        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();
        bloqueMoverIzquierda.ejecutar(personaje);

        /* si el personaje se mueve hacia la izquierda estando en (1,-1), va a (0,-1) */
        assertEquals( Arrays.asList(0, -1), personaje.obtenerPosicion() );

        BloqueMoverArriba bloqueMoverArriba = new BloqueMoverArriba();
        bloqueMoverArriba.ejecutar(personaje);

        /* si el personaje se mueve hacia la izquierda estando en (0, -1), va a (0,0) */
        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test04SeCreaUnPersonajeYSeLoMueveHaciaDiferentesSentidos() {
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

    /*
    Varias preguntas respecto a test 05.

    1) Está bien planteada la idea general?
    2) Por alguna razón, adentro de la clase BloqueInvertirComportamiento, no coinciden los bloques que le mando
       con las keys que tengo adentro, puede ser que está buscando la referencia en memoria, por eso falla?
    3) Si (2) es si, busqué algo en StackOverflow acerca de reescribir equals, puede ser?
      -Referencia : https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java
    4) Solucionando esto, hipotéticamente debería funcionar.

    @Test
    public void test05SeInvierteComportamiento() {

        BloqueMoverAbajo bloqueMoverAbajo = new BloqueMoverAbajo();       // (0, -1)
        BloqueMoverDerecha bloqueMoverDerecha = new BloqueMoverDerecha(); // (1, -1)

        List<Bloque> lista_bloques = new ArrayList<Bloque>();
        lista_bloques.add(bloqueMoverAbajo);
        lista_bloques.add(bloqueMoverDerecha);

        BloqueInvertirComportamiento bloqueInvertirComportamiento = new BloqueInvertirComportamiento(lista_bloques);

        bloqueInvertirComportamiento.ejecutar(personaje);

        // hipotéticamente, aplicó los 2 bloques previos, por ende, debería estar en (-1, 1)

        assertEquals( Arrays.asList(-1, 1), personaje.obtenerPosicion() );
    }
    */
}