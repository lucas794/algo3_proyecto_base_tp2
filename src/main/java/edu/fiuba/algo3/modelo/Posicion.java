package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> obtenerCoordenadas(){
        List<Integer> coordenadas = new ArrayList();
        coordenadas.add(posHorizontal);
        coordenadas.add(posVertical);
        return coordenadas;
    }
}
