/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class Fireball extends Weapon implements Drawable{

    /**
     *
     * @param x
     * @param y
     */
    public Fireball(int x, int y) {
        super(x, y, 10, 10, Color.RED, null, null);
        this.image = new ImageIcon("Fireball.png");
    }
    

    

    

    // Aquí puedes agregar métodos para mover la bola de fuego, detectar colisiones, etc.

    @Override
    public void draw(Graphics g) {
        if (image != null) {
        g.drawImage(image.getImage(), x, y,null);
    } else {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    }

    /**
     *
     */
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
