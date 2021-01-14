package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class BloqueRepeticion implements Bloque{
    List<Bloque> bloques = new ArrayList();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        for (Bloque i : bloques){
            i.ejecutar(personaje, dibujo);
        }
    }

    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

}
