package edu.fiuba.algo3.modelo;

public class MovimientoArriba implements Movimiento {

    public Posicion mover(Posicion posicion){
        return new Posicion(posicion.getHorizontal() , posicion.getVertical() + 1);
    }
}
