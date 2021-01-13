package edu.fiuba.algo3.modelo;

public class BloqueLevantarLapiz implements Bloque {

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.levantarLapiz();
    }
}
