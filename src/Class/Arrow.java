/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author santi
 */
public class Arrow extends Sprite {
    public Arrow(int x, int y) {
        super(x, y, 10, 10, Color.YELLOW);  // Asume que Sprite es una clase que representa un objeto en tu juego
    }

    // Aquí puedes agregar métodos para mover la flecha, detectar colisiones, etc.

    @Override
    public void draw(Graphics g) {
    }
}

