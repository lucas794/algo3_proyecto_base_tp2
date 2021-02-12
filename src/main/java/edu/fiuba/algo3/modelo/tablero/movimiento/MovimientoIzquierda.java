package edu.fiuba.algo3.modelo.tablero.movimiento;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;

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
