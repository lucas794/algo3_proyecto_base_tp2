package edu.fiuba.algo3.modelo;

public class MovimientoAbajo implements Movimiento {

    @Override
    public Posicion mover(Posicion posicion) {
        return new Posicion( posicion.getHorizontal() , posicion.getVertical() - 1 );
    }
}
