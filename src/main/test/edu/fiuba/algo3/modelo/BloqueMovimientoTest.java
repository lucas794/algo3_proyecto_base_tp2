package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BloqueMovimientoTest {

    @Test
    public void test01UnBloqueMovimientoHaceQueUnPersonajeSeMuevaHaciaArriba() {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());

        Personaje personaje = new Personaje();

        bloqueMoverArriba.ejecutar(personaje);

        assertEquals(Arrays.asList(0,1), personaje.obtenerPosicion() );
    }

    @Test
    public void test02UnBloqueMovimientoHaceQueUnPersonajePuedaMoverseDosVecesHaciaArriba() {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());

        Personaje personaje = new Personaje();

        bloqueMoverArriba.ejecutar(personaje);

        bloqueMoverArriba.ejecutar(personaje);

        assertEquals(Arrays.asList(0,2), personaje.obtenerPosicion() );
    }

    @Test
    public void test03UnBloqueMovimientoHaceQueUnPersonajeSeMuevaHaciaAbajo() {
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());

        Personaje personaje = new Personaje();

        bloqueMoverAbajo.ejecutar(personaje);

        assertEquals(Arrays.asList(0,-1), personaje.obtenerPosicion() );
    }

    @Test
    public void test04UnBloqueMovimientoHaceQueUnPersonajePuedaMoverseDosVecesHaciaAbajo() {
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());

        Personaje personaje = new Personaje();

        bloqueMoverAbajo.ejecutar(personaje);

        bloqueMoverAbajo.ejecutar(personaje);

        assertEquals(Arrays.asList(0, -2), personaje.obtenerPosicion());
    }

    @Test
    public void test05UnBloqueMovimientoHaceQueUnPersonajeSeMuevaALaIzquierda() {
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());

        Personaje personaje = new Personaje();

        bloqueMoverIzquierda.ejecutar(personaje);

        assertEquals(Arrays.asList(-1,0), personaje.obtenerPosicion() );
    }

    @Test
    public void test06UnBloqueMovimientoHaceQueUnPersonajePuedaMoverseDosVecesHaciaLaIzquierda() {
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());

        Personaje personaje = new Personaje();

        bloqueMoverIzquierda.ejecutar(personaje);

        bloqueMoverIzquierda.ejecutar(personaje);

        assertEquals(Arrays.asList(-2, 0), personaje.obtenerPosicion());
    }

    @Test
    public void test07UnBloqueMovimientoHaceQueUnPersonajeSeMuevaALaDerecha() {
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());

        Personaje personaje = new Personaje();

        bloqueMoverDerecha.ejecutar(personaje);

        assertEquals(Arrays.asList(1,0), personaje.obtenerPosicion() );
    }

    @Test
    public void test06UnBloqueMovimientoHaceQueUnPersonajePuedaMoverseDosVecesHaciaLaDerecha() {
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());

        Personaje personaje = new Personaje();

        bloqueMoverDerecha.ejecutar(personaje);

        bloqueMoverDerecha.ejecutar(personaje);

        assertEquals(Arrays.asList(2,0), personaje.obtenerPosicion());
    }




}