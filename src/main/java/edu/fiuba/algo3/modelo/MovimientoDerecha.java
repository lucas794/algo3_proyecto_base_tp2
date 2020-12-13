package edu.fiuba.algo3.modelo;

public class MovimientoDerecha implements Movimiento{

    public Posicion mover(Posicion posicion){
        return new Posicion(posicion.getHorizontal() + 1, posicion.getVertical() );
    }
}
