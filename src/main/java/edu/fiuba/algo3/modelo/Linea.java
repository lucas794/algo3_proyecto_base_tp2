package edu.fiuba.algo3.modelo;

import java.util.List;

// clase anémica momentaneamente, pero posiblemente deje de serlo cuando se implemente el dibujo en la interfaz gráfica.

public class Linea {
    private Posicion posInicial;
    private Posicion posFinal;

    public Linea(Posicion posicion) {
        this.posInicial = posicion;
    }

    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    public List<Integer> obtenerCoordenadasPosicionInicial()
    {
        return this.posInicial.obtenerCoordenadas();
    }

    public List<Integer> obtenerCoordenadasPosicionFinal()
    {
        return this.posFinal.obtenerCoordenadas();
    }

    public void dibujar(){
        //Cuando haya interfaz grafica
    }
}
