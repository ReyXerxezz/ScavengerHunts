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
public class Arrow extends Weapon implements Drawable{
    private ImageIcon image;
    

    public Arrow(int x, int y) {
        super(x, y, 17, 6,null,null);
        this.image = new ImageIcon("Arrow.png");
         // Establecer un valor predeterminado
    }

    

    // Aquí puedes agregar métodos para mover la flecha, detectar colisiones, etc.

    @Override
    public void draw(Graphics g) {
        if (image != null) {
        g.drawImage(image.getImage(), x, y,null);
    } else {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

