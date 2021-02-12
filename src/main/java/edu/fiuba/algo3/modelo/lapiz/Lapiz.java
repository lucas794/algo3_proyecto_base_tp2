package edu.fiuba.algo3.modelo.lapiz;

import edu.fiuba.algo3.modelo.Dibujo;
import edu.fiuba.algo3.modelo.Movimiento;
import edu.fiuba.algo3.modelo.Posicion;

public interface Lapiz {
    void dibujar(Movimiento movimiento, Posicion posicion, Dibujo dibujo);

}
