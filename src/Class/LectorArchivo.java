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
}
