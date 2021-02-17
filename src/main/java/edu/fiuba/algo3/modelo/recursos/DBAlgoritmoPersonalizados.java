package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.bloques.Bloque;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBAlgoritmoPersonalizados {

    private final String EXTENSION_ARCHIVO = ".algoblock";
    private final String NOMBRE_CARPETA = "algoblocks_personalizados";

    private final String ruta_programa = System.getProperty("user.dir");
    private final String ruta_madre = ruta_programa + "/" + NOMBRE_CARPETA + "/";
    private final boolean ruta_no_existe;

    public DBAlgoritmoPersonalizados() {
        ruta_no_existe = new File( ruta_madre ).mkdir();

        // si ruta_no_existe es true, es que se creó el directorio
        // si no existe, es que hay archivos adentro, habría que leerlos.
    }

    public void guardar_algoritmo( List<Bloque> bloques , String nombre_algoritmo )
    {
        FileOutputStream archivo;

        try {
            archivo = new FileOutputStream(ruta_madre + nombre_algoritmo + EXTENSION_ARCHIVO );
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(bloques);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace(); // queda por resolver, podemos lanzar una excepción.
        }
    }


    public List<Bloque> cargar_algoritmo( String nombre_algoritmo )
    {
        List<Bloque> temp_bloques = null;

        FileInputStream archivo_salida;
        try {
            archivo_salida = new FileInputStream(ruta_madre + nombre_algoritmo + EXTENSION_ARCHIVO );
            ObjectInputStream ois = new ObjectInputStream(archivo_salida);
            temp_bloques = (List<Bloque>) ois.readObject();

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return temp_bloques;
    }

    public List<List<?>> cargar_todos_algoritmos()
    {
        if( ruta_no_existe )
            return new ArrayList<>(); // lista vacia

        List<List<?>> arreglo_temporal = new ArrayList<>();

        File ruta = new File(ruta_madre);
        File[] directorioArchivos = ruta.listFiles();

        String nombre_archivo;

        for( File archivo : directorioArchivos )
        {
            nombre_archivo = archivo.getName().replaceFirst("[.][^.]+$", "");
            arreglo_temporal.add(Arrays.asList(nombre_archivo, this.cargar_algoritmo(nombre_archivo)));
        }

        return arreglo_temporal;
    }
}
