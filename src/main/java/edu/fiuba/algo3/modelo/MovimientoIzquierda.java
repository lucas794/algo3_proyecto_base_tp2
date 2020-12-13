package edu.fiuba.algo3.modelo;

public class MovimientoIzquierda implements Movimiento {

    @Override
    public Posicion mover(Posicion posicion) {
        return new Posicion(posicion.getHorizontal() - 1, posicion.getVertical() );
    }
}
