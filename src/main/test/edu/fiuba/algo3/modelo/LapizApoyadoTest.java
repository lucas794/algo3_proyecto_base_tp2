package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LapizApoyadoTest {

    Dibujo sectorDibujo;
    Linea lineaTrazada;

    @BeforeEach
    public void setUp() {
        sectorDibujo = new Dibujo();
    }

    @Test
    public void test01LapizApoyadoDibujaUnaLinea() {
        Lapiz lapiz = new LapizApoyado();
        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();
        Posicion posicion = new Posicion(0,0);

        lapiz.dibujar(movimientoDerecha, posicion, sectorDibujo);
        lineaTrazada = sectorDibujo.obtenerSectorDibujado().get(0);

        Posicion nuevaPosicion = new Posicion(1,0);

        assertEquals(lineaTrazada.obtenerCoordenadasPosicionFinal(), nuevaPosicion.obtenerCoordenadas());
    }
    
}