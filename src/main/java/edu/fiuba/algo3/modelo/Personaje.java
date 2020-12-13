package edu.fiuba.algo3.modelo;

import java.util.List;

public class Personaje {

    private Lapiz lapiz = new LapizApoyado(); // por defecto, el lapiz arranca apoyado.

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

    public boolean tieneLapizAbajo() {
        return this.lapiz.lapizLevantado();
    }
}
