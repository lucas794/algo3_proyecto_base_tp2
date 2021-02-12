package edu.fiuba.algo3.modelo;

public interface Bloque {
    void ejecutar(Personaje personaje, Dibujo dibujo);
    void ejecutarOpuesto(Personaje personaje, Dibujo dibujo);
}
