/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

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
    
    public String leerMapa (String palabra) {
    String mensaje = null;
        try (BufferedReader reader = Files.newBufferedReader(output, charset)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                }
            } catch (IOException e) {
                System.err.println("Error de E/S: " + e.getMessage());
            }
        return mensaje;
    }
}
