package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

public class Personaje {

    private Lapiz lapiz = new LapizLevantado(); // por defecto, el lapiz arranca arriba.
    private Posicion posicion_personaje = new Posicion(0,0);

    public void ejecutarBloques(List<Bloque> bloques) {
        for (Bloque i : bloques){
            i.ejecutar(this);
        }
    }

    public void mover(Movimiento movimiento) {
        this.posicion_personaje = this.posicion_personaje.desplazarPosicion(movimiento);
    }

    public void apoyarLapiz() throws LapizEstaApoyadoException {
        if (!this.tieneLapizLevantado()) throw new LapizEstaApoyadoException();
        this.lapiz = new LapizApoyado();
    }

    public void levantarLapiz() throws LapizEstaLevantadoException {
        if (this.tieneLapizLevantado()) throw new LapizEstaLevantadoException();
        this.lapiz = new LapizLevantado();
    }

    public boolean tieneLapizLevantado() {
        return !(this.lapiz.puedeDibujar());
    }

    public List<Integer> obtenerPosicion() {
        /* obtengo la posicion del personaje en forma de tupla (coordenada_x, coordenada_y) */
        return Arrays.asList(this.posicion_personaje.getHorizontal(), this.posicion_personaje.getVertical());
    }
}
