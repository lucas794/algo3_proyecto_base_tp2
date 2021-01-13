package edu.fiuba.algo3.modelo;

public class Linea {
    private Posicion posInicial;
    private Posicion posFinal;

    public Linea(Posicion posicion) {
        posInicial = posicion;
    }

    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    public void dibujar(){
        //Cuando haya interfaz grafica
    }
}
