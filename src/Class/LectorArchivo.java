/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Creature.Basilisk;
import Creature.Demon;
import Creature.Dragon;
import Creature.Giant;
import Creature.Harpy;
import Creature.Unicorn;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 *@author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class LectorArchivo {
    private final String output;

    /**
     * Ruta del archivo a leer.
     * @param output
     */
    public LectorArchivo(String output) {
        this.output = output;
    }
    
    /**
     * Lee el archivo del mapa y genera un arreglo de muros para dibujar en el mapa.
     * @return Arreglo de muros del mapa.
     */
    public ArrayList<Wall> leerMapa() {
        ArrayList<Wall> objetos = new ArrayList<>();
        int fila = 0;
        
        // Leer el archivo de texto
        try (BufferedReader br = new BufferedReader(new FileReader(output))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                char[] caracteres = linea.toCharArray();

                for (int columna = 0; columna < caracteres.length; columna+=1) {
                    if (caracteres[columna] == '1') {
                        // Crear un objeto en la posición (fila, columna)
                        Wall miObjeto = new Wall((columna*Wall.WIDTH), fila*Wall.HEIGHT);
                        objetos.add(miObjeto);
                    }
                }

                fila+=1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objetos;
    }
    
    /**
     * Lee el archivo del mapa y genera un arreglo de monstruos leídos en el archivo.
     * @return Arreglo de monstruos que están en el mapa.
     */
    public ArrayList<LivingBeing> leerMonstruos() {
    ArrayList<LivingBeing> monstruos = new ArrayList<>();
    int fila = 0;
    
    // Leer el archivo de texto
    try (BufferedReader br = new BufferedReader(new FileReader(output))) {
        String linea;

        while ((linea = br.readLine()) != null) {
            char[] caracteres = linea.toCharArray();

            for (int columna = 0; columna < caracteres.length; columna+=1) {
                if (caracteres[columna] == '2') {
                    // Crear un monstruo en la posición (fila, columna)
                    
                    Basilisk miMonstruo = new Basilisk(columna*Wall.WIDTH, fila*Wall.HEIGHT);
                    monstruos.add(miMonstruo);
                }
                if (caracteres[columna] == '3') {
                    // Crear un monstruo en la posición (fila, columna)
                    
                    Demon miMonstruo = new Demon(columna*Wall.WIDTH, fila*Wall.HEIGHT);
                    monstruos.add(miMonstruo);
                }
                if (caracteres[columna] == '4') {
                    // Crear un monstruo en la posición (fila, columna)
                    
                    Dragon miMonstruo = new Dragon(columna*Wall.WIDTH, fila*Wall.HEIGHT);
                    monstruos.add(miMonstruo);
                }
                if (caracteres[columna] == '5') {
                    // Crear un monstruo en la posición (fila, columna)
                    
                    Giant miMonstruo = new Giant(columna*Wall.WIDTH, fila*Wall.HEIGHT);
                    monstruos.add(miMonstruo);
                }
                if (caracteres[columna] == '6') {
                    // Crear un monstruo en la posición (fila, columna)
                    
                    Harpy miMonstruo = new Harpy(columna*Wall.WIDTH, fila*Wall.HEIGHT);
                    monstruos.add(miMonstruo);
                }
                if (caracteres[columna] == '7') {
                    // Crear un monstruo en la posición (fila, columna)
                    
                    Unicorn miMonstruo = new Unicorn(columna*(Wall.WIDTH), fila*(Wall.HEIGHT));
                    monstruos.add(miMonstruo);
                }
            }

            fila+=1;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return monstruos;
}

}
