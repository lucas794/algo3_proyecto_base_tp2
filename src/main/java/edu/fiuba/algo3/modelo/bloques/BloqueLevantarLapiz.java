package edu.fiuba.algo3.modelo.bloques;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.Personaje;

import java.io.Serializable;

public class BloqueLevantarLapiz implements Bloque, Serializable{

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.levantarLapiz();
    }

    @Override
    public void ejecutarOpuesto(Personaje personaje, Dibujo dibujo) {
        personaje.apoyarLapiz();
    }
}
