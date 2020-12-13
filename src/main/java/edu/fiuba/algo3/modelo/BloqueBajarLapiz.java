package edu.fiuba.algo3.modelo;

public class BloqueBajarLapiz implements Bloque {

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.apoyarLapiz();
    }
}
