package edu.fiuba.algo3.modelo;

public class Posicion {
    private final int posHorizontal;
    private final int posVertical;

    public Posicion(int posHorizontal, int posVertical) {
        this.posHorizontal = posHorizontal;
        this.posVertical = posVertical;
    }

    public int getHorizontal() { return posHorizontal; }

    public int getVertical() { return posVertical;}

    public Posicion desplazarPosicion(Movimiento movimiento){
        return (movimiento.mover(this));
    }

 /*  public Posicion desplazamientoHorizontal(Movimiento movimiento) {
        return (movimiento.mover(this));
    }

    public Posicion desplazamientoVertical(Movimiento movimiento) {
        return (movimiento.mover(this));
    }*/
}
