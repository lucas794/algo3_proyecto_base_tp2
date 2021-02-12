package edu.fiuba.algo3.modelo.tablero.movimiento;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;

public class MovimientoArriba implements Movimiento {

    public void mover(Posicion posicion){
        posicion.desplazarArriba();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoAbajo();
    }
}
