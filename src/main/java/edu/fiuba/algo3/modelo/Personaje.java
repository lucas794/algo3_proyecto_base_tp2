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

    /* No es necesario tirar una excepción si el lapiz ya lo tiene levantado
    o apoyado, solamente ignorar el mensaje */

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
        /* obtengo la posicion del personaje en forma de tupla (coordenada_x, coordenada_y) */

        /* revisar esta línea porque si bien funciona, está mal
        Es posible una solución del tipo
        return this.posicion_personaje.obtenerCoordenadas();
        y crear el metodo obtenerCoordenadas en Posicion
        */
        return Arrays.asList(this.posicion_personaje.getHorizontal(), this.posicion_personaje.getVertical());
    }
}
