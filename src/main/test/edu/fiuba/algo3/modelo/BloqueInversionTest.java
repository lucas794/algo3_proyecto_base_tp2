package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

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



}
