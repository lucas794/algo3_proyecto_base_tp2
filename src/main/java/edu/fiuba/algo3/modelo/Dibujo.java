package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    private List<Linea> lineas = new ArrayList<>();

    public void agregarLinea(Movimiento movimiento, Posicion posicion) {
        Linea linea = new Linea(posicion);
        movimiento.mover(posicion);
        linea.setPosFinal(posicion);
        lineas.add(linea);
    }

    public void dibujar(){
        for(Linea i : lineas){
            i.dibujar();
        }
    }
}
