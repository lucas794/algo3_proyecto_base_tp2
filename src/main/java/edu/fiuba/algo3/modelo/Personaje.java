package edu.fiuba.algo3.modelo;

import java.util.List;

public class Personaje {

    private Lapiz lapiz = new LapizLevantado(); // por defecto, el lapiz arranca arriba.

    public void ejecutarBloques(List<Bloque> bloques) {
        /* hay que implementarlo */
    }

    public void mover(Movimiento movimiento) {
        /* hay que implementarlo */
    }

    public void apoyarLapiz() {
        this.lapiz = new LapizApoyado();
    }

    public void levantarLapiz() {
        this.lapiz = new LapizLevantado();
    }

    public boolean tieneLapizLevantado() {
        return this.lapiz.lapizLevantado();
    }
}
