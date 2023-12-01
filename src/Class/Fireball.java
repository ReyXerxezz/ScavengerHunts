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
public class Fireball extends Sprite {
    public Fireball(int x, int y) {
        super(x, y, 10, 10, Color.RED);  // Asume que Sprite es una clase que representa un objeto en tu juego
    }

    // Aquí puedes agregar métodos para mover la bola de fuego, detectar colisiones, etc.

    @Override
    public void draw(Graphics g) {
    }
}
