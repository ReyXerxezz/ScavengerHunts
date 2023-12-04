/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Assets {
    private static Image[] numberImages;

    static {
        // Cargar las imágenes en el array numberImages
        numberImages = new Image[10];
        for (int i = 0; i <= 9; i++) {
            String imagePath = "" + i + ".png";
            numberImages[i] = new ImageIcon(imagePath).getImage();
        }
    }

    public static Image numbers(int digit) {
        if (digit >= 0 && digit <= 9) {
            return numberImages[digit];
        } else {
            // Manejar el caso en el que el dígito no está en el rango esperado
            // Puedes devolver una imagen predeterminada o lanzar una excepción, según tus necesidades
            return null;
        }
    }
}
