package edu.fiuba.algo3.modelo;

public class LapizApoyado implements Lapiz {

    @Override
    public void dibujar(Movimiento movimiento, Posicion posicion, Dibujo dibujo){
        dibujo.agregarLinea(movimiento,posicion);
    }

    /* quedó por la primera entrega pero necesita un refactor */

    @Override
    public boolean puedeDibujar() {
        return true;
    }
}
