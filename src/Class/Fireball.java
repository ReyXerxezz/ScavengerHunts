/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author santi
 */
public class Fireball extends Weapon implements Drawable{

    public Fireball(int x, int y) {
        super(x, y, 10, 10, Color.RED, null);
    }
    

    

    

    // Aquí puedes agregar métodos para mover la bola de fuego, detectar colisiones, etc.

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
