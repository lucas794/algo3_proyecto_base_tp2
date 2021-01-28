package edu.fiuba.algo3.modelo;

public class LapizApoyado implements Lapiz {

    @Override
    public void dibujar(Movimiento movimiento, Posicion posicion, Dibujo dibujo){
        dibujo.agregarLinea(movimiento,posicion);
    }
}
