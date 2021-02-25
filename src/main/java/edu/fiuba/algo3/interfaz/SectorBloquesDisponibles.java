package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

// necesito que esto extienda de Observador, no de VBox (solo puedo extender de una clase)
// Una vez que solo extienda de Observador, el botonGuardarAlgoritmo se cambiaría de activado a desactivado.
public class SectorBloquesDisponibles extends VBox {

    private static ContenedorBotonera contenedor;

    public SectorBloquesDisponibles(SectorDibujo sectorDibujo, Personaje personaje){
        Label upper = new Label("Bloques Disponibles");
        upper.setMaxWidth(Double.MAX_VALUE);
        upper.setAlignment(Pos.CENTER);
        this.getChildren().add(upper);

        contenedor = new ContenedorBotonera(sectorDibujo, personaje);
        VBox contenedorBotonera = contenedor.obtenerBotones();

        DBAlgoritmoPersonalizados db = new DBAlgoritmoPersonalizados();
        List<List<?>> info_algoritmos_personalizados = db.cargar_todos_algoritmos();

        info_algoritmos_personalizados.forEach( info -> contenedorBotonera.getChildren().add( new Button( (String) info.get(0))));

        contenedorBotonera.setAlignment( Pos.TOP_CENTER );
        contenedorBotonera.setSpacing( 2 );

        this.getChildren().add(contenedorBotonera);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public ContenedorBotonera obtenerBotonera()
    {
        return contenedor.getContenedorBotonera();
    }
}
