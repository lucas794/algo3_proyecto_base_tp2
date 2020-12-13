package edu.fiuba.algo3.modelo;

public class BloqueMoverArriba implements Bloque {

    @Override
    public void ejecutar(Personaje personaje) {
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        personaje.mover(movimientoArriba);
    }
}
