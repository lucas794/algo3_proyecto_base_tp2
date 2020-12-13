package edu.fiuba.algo3.modelo;

public class BloqueMoverIzquierda implements Bloque {

    @Override
    public void ejecutar(Personaje personaje) {
        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        personaje.mover(movimientoIzquierda);
    }
}
