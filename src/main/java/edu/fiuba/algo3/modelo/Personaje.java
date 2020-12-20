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
        movimiento.mover(this.posicion_personaje);
    }

    public void apoyarLapiz(){
        this.lapiz = new LapizApoyado();
    }

    public void levantarLapiz(){
        this.lapiz = new LapizLevantado();
    }

    public boolean tieneLapizLevantado() {
        return !(this.lapiz.puedeDibujar());
    }

    public List<Integer> obtenerPosicion() {

        return this.posicion_personaje.obtenerCoordenadas();
    }
}
