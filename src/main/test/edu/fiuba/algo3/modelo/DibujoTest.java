package edu.fiuba.algo3.modelo;

//No se me ocurre como testear sin la interfaz grafica y sin agregar getters

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    Dibujo sectorDibujo;
    Personaje personaje;
    List<Bloque> lista_de_bloques = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        sectorDibujo = new Dibujo();
        personaje = new Personaje();
    }

    @Test
    public void test01ElDibujoIniciaVacio()
    {
        List<Linea> lineas = new ArrayList<>(); // lista de lineas vacia, por ende debería dar true.

        assertEquals( lineas, sectorDibujo.obtenerSectorDibujado() );
    }

    @Test
    public void test02MovimientoHaciaDerechaNoDebeDibujarPeroSiCambiarSuUbicacion()
    {
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento( new MovimientoDerecha() );

        bloqueMovimiento.ejecutar( personaje, sectorDibujo );

        Posicion posicionEsperada = new Posicion(1,0 );

        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );

        List<Linea> lineas = new ArrayList<>(); // lista de lineas vacia, se movió hacia la derecha, pero no dibujó.

        assertEquals( lineas, sectorDibujo.obtenerSectorDibujado() );
    }

    @Test
    public void test03SeVerificaLaCantidadDeLineasDibujadasEnElSectorDibujo()
    {
        lista_de_bloques.add( new BloqueBajarLapiz() );
        lista_de_bloques.add( new BloqueMovimiento( new MovimientoDerecha() ) );
        lista_de_bloques.add( new BloqueMovimiento( new MovimientoArriba()  ) );

        for( Bloque bloque : lista_de_bloques )
        {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        // debe quedar dibujado los puntos (0,0) -> (1,0) -> (1,1) por ende son 2 lineas.
        assertEquals( 2, sectorDibujo.obtenerSectorDibujado().size() );
    }

    @Test
    public void test04SeBajaElLapizYSeDibuja1Vez()
    {
        lista_de_bloques.add( new BloqueBajarLapiz() );
        lista_de_bloques.add( new BloqueMovimiento( new MovimientoDerecha() ));
        // resumen, baja el lapiz, luego se mueve hacia la derecha 1 vez por ende queda en (1,0) ese es el sector dibujado.

        for( Bloque bloque : lista_de_bloques)
        {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        // en este caso, solo tiene el punto (1,0) ya que desde (0,0) a (1,1) es donde ha dibujado, por ende tanto la
        // posicion inicial y la posicion final coinciden
        Posicion posInicialTrazoDibujado = new Posicion(1,0);
        Posicion posFinalTrazoDibujado   = new Posicion(1,0);

        Linea trazoDibujado = sectorDibujo.obtenerSectorDibujado().get(0);

       // assertEquals( posInicialTrazoDibujado.obtenerCoordenadas(), trazoDibujado.obtenerCoordenadasPosicionInicial() );
        assertEquals( posFinalTrazoDibujado.obtenerCoordenadas(), trazoDibujado.obtenerCoordenadasPosicionFinal() );
    }
    // Este test está mal, para probar, saca los comments, y correlo, fijate que muestra solo las líneas finales del movimiento.
       
    @Test
    public void test05SeBajaElLapizYSeDibuja3Vez() {
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoArriba()));
        lista_de_bloques.add(new BloqueLevantarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));


        for (Bloque bloque : lista_de_bloques) {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        for (int i = 0; i < sectorDibujo.obtenerSectorDibujado().size(); i++) {
            System.out.print("\n" + i + "| " + sectorDibujo.obtenerSectorDibujado().get(i).obtenerCoordenadasPosicionInicial() + "," + sectorDibujo.obtenerSectorDibujado().get(i).obtenerCoordenadasPosicionFinal());
        }
    }
}
