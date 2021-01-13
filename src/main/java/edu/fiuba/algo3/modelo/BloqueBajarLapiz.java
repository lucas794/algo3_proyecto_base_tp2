package edu.fiuba.algo3.modelo;

public class BloqueBajarLapiz implements Bloque {

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.apoyarLapiz();
    }
}
