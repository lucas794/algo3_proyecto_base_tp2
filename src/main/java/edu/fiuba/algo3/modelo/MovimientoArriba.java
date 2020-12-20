package edu.fiuba.algo3.modelo;

public class MovimientoArriba implements Movimiento {

    public void mover(Posicion posicion){
        posicion.desplazarArriba();
    }
}
