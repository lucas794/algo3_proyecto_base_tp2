package edu.fiuba.algo3.modelo;

public class MovimientoAbajo implements Movimiento {

    @Override
    public void mover(Posicion posicion) {
        posicion.desplazarAbajo();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoArriba();
    }
}
