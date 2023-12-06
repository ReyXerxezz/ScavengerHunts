/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Clase muro que se utiliza mara demarcar el mapa del juego.
 * @author Santiago Jimenez
 * @author Daniel Felipe López
 */
public class Wall extends Sprite{

    /**
     * Ancho del muro.
     */
    public static final int WIDTH = 35;

    /**
     * Altura del muro.
     */
    public static final int HEIGHT = 40;
    private ImageIcon wall = new ImageIcon("Wall.png");

    /**
     * Constructor de la clase muro.
     * @param x
     * @param y
     */
    public Wall(int x, int y) {
        super(x, y, WIDTH, HEIGHT, Color.GRAY);
    }
    
    @Override
    public void draw(Graphics g) {
        wall.paintIcon(null, g, x, y);
    }

    /**
     * @return the WIDTH
     */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     * @return the HEIGHT
     */
    public int getHEIGHT() {
        return HEIGHT;
    }
    
    
}
