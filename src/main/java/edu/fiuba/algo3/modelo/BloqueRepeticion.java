package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class BloqueRepeticion implements Bloque{
    List<Bloque> bloques = new ArrayList<>();
    private final double veces_repeticion;

    public BloqueRepeticion(double veces) {
        this.veces_repeticion = veces;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        for( int j = 0; j < this.veces_repeticion; j++ ) {
            bloques.forEach( bloque -> bloque.ejecutar(personaje, dibujo) );
        }
    }

    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

    public void agregarBloque( List<Bloque> arreglo_de_bloques )
    {
        // a cada elemento en arreglo de bloque lo metemos al arreglo bloques.
        bloques.addAll(arreglo_de_bloques);
    }
}
