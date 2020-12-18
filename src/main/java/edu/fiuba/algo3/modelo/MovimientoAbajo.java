package edu.fiuba.algo3.modelo;

public class MovimientoAbajo implements Movimiento {

    /* devolver una nueva instancia de posición es algo rebundante, podes modificar la actual posición, cambiarle
    la coordenada y devolver la misma posición con el nuevo valor aplicado.
     */

    @Override
    public Posicion mover(Posicion posicion) {
        return new Posicion( posicion.getHorizontal() , posicion.getVertical() - 1 );
    }
}
