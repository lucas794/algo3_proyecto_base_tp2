package edu.fiuba.algo3.modelo;

public class BloqueMoverAbajo implements Bloque {

    @Override
    public void ejecutar(Personaje personaje) {
        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        personaje.mover(movimientoAbajo);
    }
}
