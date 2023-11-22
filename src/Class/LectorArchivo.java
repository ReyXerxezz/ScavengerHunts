/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class LectorArchivo {
    private final String output;

    public LectorArchivo(String output) {
        this.output = output;
    }
    
    public List<Wall> leerMapa() {
        List<Wall> objetos = new ArrayList<>();

        // Leer el archivo de texto
        try (BufferedReader br = new BufferedReader(new FileReader(output))) {
            String linea;
            int fila = 0;

            while ((linea = br.readLine()) != null) {
                char[] caracteres = linea.toCharArray();

                for (int columna = 0; columna < caracteres.length; columna++) {
                    if (caracteres[columna] == '*') {
                        // Crear un objeto en la posición (fila, columna)
                        Wall miObjeto = new Wall(fila*Wall.WIDTH, columna*Wall.HEIGHT);
                        objetos.add(miObjeto);
                    }
                }

                fila++;
            }

            // Imprimir la lista de objetos o realizar otras operaciones según sea necesario
            for (Wall objeto : objetos) {
                System.out.println("Objeto en posición (" + objeto.getX() + ", " + objeto.getY() + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objetos;
    }
}
