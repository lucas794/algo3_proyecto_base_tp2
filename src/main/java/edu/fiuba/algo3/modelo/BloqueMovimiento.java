package edu.fiuba.algo3.modelo;

public class BloqueMovimiento implements Bloque{
    Movimiento movimiento;

    public BloqueMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.mover(movimiento);
    }
}

