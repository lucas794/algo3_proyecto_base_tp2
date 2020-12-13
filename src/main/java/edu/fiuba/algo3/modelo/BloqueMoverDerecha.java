package edu.fiuba.algo3.modelo;

public class BloqueMoverDerecha implements Bloque {

    @Override
    public void ejecutar(Personaje personaje) {
        MovimientoDerecha moverDerecha = new MovimientoDerecha();

        personaje.mover(moverDerecha);
    }
}
