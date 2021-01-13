package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    /* Pruebas unitarias*/
    @Test
    public void test01ElPersonajeSePuedeMoverHaciaArriba(){
        Personaje personaje = new Personaje();
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        personaje.mover(movimientoArriba, new Dibujo());

        assertEquals( Arrays.asList(0, 1), personaje.obtenerPosicion() );
    }

    @Test
    public void test02ElPersonajePuedeRepetirElMomientoHaciaArriba(){
        Personaje personaje = new Personaje();
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        personaje.mover(movimientoArriba, new Dibujo());
        personaje.mover(movimientoArriba, new Dibujo());

        assertEquals( Arrays.asList(0, 2), personaje.obtenerPosicion() );
    }

    @Test
    public void test03ElPersonajeSePuedeMoverHaciaAbajo(){
        Personaje personaje = new Personaje();
        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        personaje.mover(movimientoAbajo, new Dibujo());

        assertEquals( Arrays.asList(0, -1), personaje.obtenerPosicion() );
    }

    @Test
    public void test04ElPersonajePuedeRepetirElMovimientoHaciaAbajo(){
        Personaje personaje = new Personaje();
        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        personaje.mover(movimientoAbajo, new Dibujo());
        personaje.mover(movimientoAbajo, new Dibujo());

        assertEquals( Arrays.asList(0, -2), personaje.obtenerPosicion() );
    }

    @Test
    public void test05ElPersonajeSePuedeMoverHaciaLaIzquierda(){
        Personaje personaje = new Personaje();
        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        personaje.mover(movimientoIzquierda, new Dibujo());

        assertEquals( Arrays.asList(-1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test06ElPersonajePuedeRepetirElMovimientoHaciaLaIzquierda(){
        Personaje personaje = new Personaje();
        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        personaje.mover(movimientoIzquierda, new Dibujo());
        personaje.mover(movimientoIzquierda, new Dibujo());

        assertEquals( Arrays.asList(-2, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test07ElPersonajeSePuedeMoverHaciaLaDerecha(){
        Personaje personaje = new Personaje();
        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        personaje.mover(movimientoDerecha, new Dibujo());

        assertEquals( Arrays.asList(1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test08ElPersonajePuedeRepetirElMovimientoHaciaLaDerecha(){
        Personaje personaje = new Personaje();
        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        personaje.mover(movimientoDerecha, new Dibujo());
        personaje.mover(movimientoDerecha, new Dibujo());

        assertEquals( Arrays.asList(2, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test09ElPersonajePuedeLevantarElLapizCuandoElLapizEstaApoyado() {
        Personaje personaje = new Personaje();

        personaje.apoyarLapiz();
        personaje.levantarLapiz();

        assertTrue(personaje.tieneLapizLevantado());
    }

    @Test
    public void test10ElPersonajePuedeLevantarElLapizCuandoElLapizEstaApoyado() {
        Personaje personaje = new Personaje();

        personaje.apoyarLapiz();
        personaje.levantarLapiz();

        assertTrue(personaje.tieneLapizLevantado());
    }


    @Test
    public void test11ElPersonajePuedeApoyarElLapizCuandoElLapizEstaLevantado() {
        Personaje personaje = new Personaje();

        personaje.apoyarLapiz();

        assertFalse(personaje.tieneLapizLevantado());
    }

    @Test
    public void test12ElMetdodtieneLapizLevantadoDevuelveTrueCuandoElLapizEstaLevantado() {
        Personaje personaje = new Personaje();

        assertTrue(personaje.tieneLapizLevantado());
    }

    @Test
    public void test13ElMetdodtieneLapizLevantadoDevuelveFalseCuandoElLapizEstaApoyado() {
        Personaje personaje = new Personaje();

        personaje.apoyarLapiz();

        assertFalse(personaje.tieneLapizLevantado());
    }



    /*Pruebas de integracion*/
    Personaje personaje;

    @BeforeEach
    public void setUp() {
        personaje = new Personaje();
    }

    private void ejecutarBloque(Personaje personaje, Bloque bloque, int cantidad){
        for(int i = 0; i < cantidad; i++)
            bloque.ejecutar(personaje, new Dibujo());
    }

    @Test
    public void test01SeCreaUnPersonajeYPorDefectoTieneElLapizHaciaArriba()
    {
        assertTrue( personaje.tieneLapizLevantado() ); /* inicialmente, tiene el lapiz levantado */
    }

    @Test
    public void test02SeBajayVuelveALevantarElLapizConUnBloque(){
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();

        bloqueBajarLapiz.ejecutar(personaje, new Dibujo());
        bloqueLevantarLapiz.ejecutar(personaje, new Dibujo());

        /* subimos el lapiz con el último bloque, debe dar true */
        assertTrue( personaje.tieneLapizLevantado() );
    }

    @Test
    public void test03SeCreaUnPersonajeYLaPosicionInicialEs0_0(){
        assertEquals( Arrays.asList(0,0), personaje.obtenerPosicion() );
    }

    @Test
    public void test04SeMueveUnPersonajeUnaPosicionALaDerecha(){
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());
        ejecutarBloque(personaje,bloqueMoverDerecha,1);

        assertEquals( Arrays.asList(1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test05SeMueveUnPersonajeTresPosicionesALaDerecha(){
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());
        ejecutarBloque(personaje,bloqueMoverDerecha,3);

        assertEquals( Arrays.asList(3, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test06SeMueveUnPersonajeUnaPosicionALaIzquierda(){
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        ejecutarBloque(personaje,bloqueMoverIzquierda,1);

        assertEquals( Arrays.asList(-1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test07SeMueveUnPersonajeTresPosicionesALaIzquierda(){
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        ejecutarBloque(personaje,bloqueMoverIzquierda,3);

        assertEquals( Arrays.asList(-3, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test08SeMueveUnPersonajeUnaPosicionArriba(){
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        ejecutarBloque(personaje,bloqueMoverArriba,1);

        assertEquals( Arrays.asList(0, 1), personaje.obtenerPosicion() );
    }

    @Test
    public void test09SeMueveUnPersonajeTresPosicionesArriba(){
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        ejecutarBloque(personaje,bloqueMoverArriba,3);

        assertEquals( Arrays.asList(0, 3), personaje.obtenerPosicion() );
    }

    @Test
    public void test10SeMueveUnPersonajeUnaPosicionAbajo(){
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());
        ejecutarBloque(personaje,bloqueMoverAbajo,1);

        assertEquals( Arrays.asList(0, -1), personaje.obtenerPosicion() );
    }

    @Test
    public void test09SeMueveUnPersonajeTresPosicionesAbajo(){
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());
        ejecutarBloque(personaje,bloqueMoverAbajo,3);

        assertEquals( Arrays.asList(0, -3), personaje.obtenerPosicion() );
    }


    @Test
    public void test10SeMueveElPersonajeParaArribaYAbajoDebeTerminarEn0_0() {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());

        ejecutarBloque(personaje,bloqueMoverArriba,1);
        ejecutarBloque(personaje,bloqueMoverAbajo,1);

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test11SeMueveElPersonajeParaIzquierdaYDerechaDebeTerminarEn0_0() {
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());

        ejecutarBloque(personaje,bloqueMoverIzquierda,1);
        ejecutarBloque(personaje,bloqueMoverDerecha,1);

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test12SeMueveElPersonajeHaciaDiferentesSentidos() {
        List<Movimiento> listaDeMovimiento = new ArrayList<>();
        listaDeMovimiento.add(new MovimientoAbajo());
        listaDeMovimiento.add(new MovimientoAbajo());
        listaDeMovimiento.add(new MovimientoDerecha());
        listaDeMovimiento.add(new MovimientoArriba());

        List<List<Integer>> lista_posiciones_esperadas = new ArrayList<>();
        lista_posiciones_esperadas.add( Arrays.asList(0, -1) );
        lista_posiciones_esperadas.add( Arrays.asList(0, -2) );
        lista_posiciones_esperadas.add( Arrays.asList(1, -2) );
        lista_posiciones_esperadas.add( Arrays.asList(1, -1) );

        int i;
        for( i = 0; i < lista_posiciones_esperadas.size( ); i++ )
        {
            BloqueMovimiento bloqueMovimiento = new BloqueMovimiento( listaDeMovimiento.get(i) );
            ejecutarBloque(personaje, bloqueMovimiento, 1); // usamos la misma función creada
            assertEquals( lista_posiciones_esperadas.get(i), personaje.obtenerPosicion() );
        }
    }

    @Test
    public void test13SeMueveElPersonajeConListaDeBloquesMovimientoHaciaIzquierda() {
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        List<Bloque> bloques = new ArrayList();
        for (int i = 0; i < 10; i++) {
            bloques.add(bloqueMoverIzquierda);
        }

        personaje.ejecutarBloques(bloques, new Dibujo());

        assertEquals( Arrays.asList(-10, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test14SeMueveElPersonajeConListaDeBloquesMovimientoHaciaArribaYAbajo() {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());
        List<Bloque> bloques = new ArrayList();
        for (int i = 0; i < 50; i++) {
            bloques.add(bloqueMoverAbajo);
            bloques.add(bloqueMoverArriba);
        }

        personaje.ejecutarBloques(bloques, new Dibujo());

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }
}