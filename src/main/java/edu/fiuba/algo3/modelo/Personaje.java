package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

public class Personaje {

    private Lapiz lapiz = new LapizLevantado(); // por defecto, el lapiz arranca arriba.
    private Posicion posicion_personaje = new Posicion(0,0);

    public void ejecutarBloques(List<Bloque> bloques) {
        /* hay que implementarlo */
    }

    public void mover(Movimiento movimiento) {
        this.posicion_personaje = this.posicion_personaje.desplazarPosicion(movimiento);
    }

    public void apoyarLapiz() {
        this.lapiz = new LapizApoyado();
    }

    public void levantarLapiz() {
        this.lapiz = new LapizLevantado();
    }

    public boolean tieneLapizLevantado() {
        return !(this.lapiz.puedeDibujar());
    }

    public <T> List<T> obtenerPosicion() {
        /* obtengo la posicion del personaje en forma de tupla (coordenada_x, coordenada_y) */
        return (List<T>) Arrays.asList(this.posicion_personaje.getHorizontal(), this.posicion_personaje.getVertical());
    }
}
