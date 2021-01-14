package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueRepeticionTest {

    BloqueRepeticion bloqueRepeticion;
    Personaje personaje;
    Dibujo dibujo;
    List<Bloque> bloquesAEjecutar;

    @BeforeEach
    public void setUp(){
        bloqueRepeticion = new BloqueRepeticion();
        personaje = new Personaje();
        dibujo = new Dibujo();
        bloquesAEjecutar = new ArrayList();
    }
    @Test
    public void test01ElPersonajeNoCambiaDePosicionConUnBLoqueRepeticionVacio(){
        bloqueRepeticion.ejecutar(personaje,dibujo);
        assertEquals( Arrays.asList(0,0), personaje.obtenerPosicion());
    }
    @Test
    public void test02SeAgregarBloquesDeMovimientoALaDerechaYElPersonajeSeMueve(){

        for(int i = 0; i < 10 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoDerecha()));
        }

        for(Bloque i : bloquesAEjecutar){
            bloqueRepeticion.agregarBloque(i);
        }

        bloqueRepeticion.ejecutar(personaje,dibujo);

        assertEquals( Arrays.asList(10,0), personaje.obtenerPosicion());
    }
    @Test
    public void test03SeAgregarBloquesDeMovimientoALaIzquierdaYElPersonajeSeMueve(){

        for(int i = 0; i < 15 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoIzquierda()));
        }

        for(Bloque i : bloquesAEjecutar){
            bloqueRepeticion.agregarBloque(i);
        }

        bloqueRepeticion.ejecutar(personaje,dibujo);

        assertEquals( Arrays.asList(-15,0), personaje.obtenerPosicion());
    }

    @Test
    public void test04SeAgregarBloquesDeMovimientoEnTodasLasDireccionesYElPersonajeSeMueve(){

        for(int i = 0; i < 15 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoIzquierda()));
        }
        for(int i = 0; i < 20 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoDerecha()));
        }
        for(int i = 0; i < 30 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoArriba()));
        }
        for(int i = 0; i < 50 ; i++) {
            bloquesAEjecutar.add(new BloqueMovimiento(new MovimientoAbajo()));
        }

        for(Bloque i : bloquesAEjecutar){
            bloqueRepeticion.agregarBloque(i);
        }

        bloqueRepeticion.ejecutar(personaje,dibujo);

        assertEquals( Arrays.asList(5,-20), personaje.obtenerPosicion());
    }

    //falta agregar Tests con el bloque de levatar y bajar lapiz, pero no se me ocurre como testear esto
}
