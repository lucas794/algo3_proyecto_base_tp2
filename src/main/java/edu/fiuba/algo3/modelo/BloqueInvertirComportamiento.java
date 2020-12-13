package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BloqueInvertirComportamiento implements Bloque {

    HashMap<Bloque, Bloque> hashBloques = new HashMap<>();
    List<Bloque> lista_de_bloques;

    public BloqueInvertirComportamiento(List<Bloque> listado_bloques) {
        this.lista_de_bloques = listado_bloques;

        /* el invertido de un movimiento a la derecha es el movimiento a la izquierda */
        this.hashBloques.put(new BloqueMoverDerecha(), new BloqueMoverIzquierda());

        /* el invertido de un movimiento a la izquierda, es el movimiento a la derecha */
        this.hashBloques.put(new BloqueMoverIzquierda(), new BloqueMoverDerecha());

        /* el invertido de un movimiento hacia arriba, es el movimiento hacia abajo */
        this.hashBloques.put(new BloqueMoverArriba(), new BloqueMoverAbajo());

        /* el invertido de un movimiento hacia abajo, es el movimiento hacia arriba */
        this.hashBloques.put(new BloqueMoverAbajo(), new BloqueMoverArriba());

    }

    @Override
    public void ejecutar(Personaje personaje) {
        /* deberíamos crear una excepción acá por si se llegara a enviar un bloque inexistente o inválido */
        for( Bloque bloque : lista_de_bloques )
            this.hashBloques.get(bloque).ejecutar(personaje);
    }
}
