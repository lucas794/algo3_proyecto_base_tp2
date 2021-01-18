package edu.fiuba.algo3.modelo;

import java.util.List;

public class Personaje {

    private Lapiz lapiz = new LapizLevantado(); // por defecto, el lapiz arranca arriba.
    private Posicion posicion_personaje = new Posicion(0,0);

    public void ejecutarBloques(List<Bloque> bloques, Dibujo dibujo) {
        bloques.stream().forEach( bloque -> bloque.ejecutar(this, dibujo) );
    }

    public void mover(Movimiento movimiento, Dibujo dibujo) {
        lapiz.dibujar(movimiento, this.posicion_personaje, dibujo);
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
