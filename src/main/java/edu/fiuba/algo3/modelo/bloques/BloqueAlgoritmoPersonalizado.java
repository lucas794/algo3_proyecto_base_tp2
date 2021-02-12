package edu.fiuba.algo3.modelo.bloques;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;

import java.util.ArrayList;
import java.util.List;

public class BloqueAlgoritmoPersonalizado implements Bloque {

    List<Bloque> algoritmo_a_ejecutar = new ArrayList<>();
    String nombre_algoritmo;

    public BloqueAlgoritmoPersonalizado( String nombre_algoritmo_a_cargar ) {
        // aquí debería cargarse el algoritmo
    }

    public BloqueAlgoritmoPersonalizado( List<Bloque> bloques, String nombre_algoritmo_a_guardar ) {
        // posiblemente requiera mas detalles pero es una base.
        this.algoritmo_a_ejecutar.addAll( bloques );
        this.nombre_algoritmo = nombre_algoritmo_a_guardar;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.algoritmo_a_ejecutar.forEach( bloque -> bloque.ejecutar(personaje, dibujo) );
    }

    @Override
    public void ejecutarOpuesto(Personaje personaje, Dibujo dibujo) {
        this.algoritmo_a_ejecutar.forEach( bloque -> bloque.ejecutarOpuesto(personaje, dibujo) );
    }
}
