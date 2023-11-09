/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.Point;
import java.io.BufferedReader;
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
    private final Path output;
    private final Charset charset;

    public LectorArchivo(Path output, Charset charset) {
        this.output = output;
        this.charset = charset;
    }
    
    public List<Point> leerMapa() {
        List<Point> coordenadasMuros = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(output, charset)) {
            String line;
            int fila = 0;

            while ((line = reader.readLine()) != null) {
                for (int columna = 0; columna < line.length(); columna++) {
                    char c = line.charAt(columna);
                    if (c == '*') {  // Cambiado a '*' para representar un muro
                        coordenadasMuros.add(new Point(columna, fila));
                    }
                }
                fila++;
            }
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }

        return coordenadasMuros;
    }
}
