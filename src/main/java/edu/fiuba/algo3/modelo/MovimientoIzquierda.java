package edu.fiuba.algo3.modelo;

public class MovimientoIzquierda implements Movimiento {

    @Override
    public void mover(Posicion posicion) {
        posicion.desplazarIzquierda();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoDerecha();
    }
}
