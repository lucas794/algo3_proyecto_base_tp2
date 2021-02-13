package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.bloques.Bloque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBAlgoritmoPersonalizados {

    private final String EXTENSION_ARCHIVO = ".algoblock";

    public void guardar_algoritmo( List<Bloque> bloques , String nombre_algoritmo )
    {
        /*
        FileOutputStream archivo;

        try {
            archivo = new FileOutputStream(nombre_algoritmo + EXTENSION_ARCHIVO );
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(bloques);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace(); // queda por resolver, podemos lanzar una excepción.
        }*/
    }

    /*
    public List<Bloque> cargar_algoritmo( String nombre_algoritmo )
    {

        List<Bloque> temp_bloques = null;

        FileInputStream archivo_salida;
        try {
            archivo_salida = new FileInputStream(nombre_algoritmo + EXTENSION_ARCHIVO );
            ObjectInputStream ois = new ObjectInputStream(archivo_salida);
            temp_bloques = (List<Bloque>) ois.readObject();

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return temp_bloques;
    }
    */
}
