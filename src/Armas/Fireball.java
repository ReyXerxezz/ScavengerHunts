/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
import Knight.Knight;
import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class Fireball extends Weapon implements Drawable{
    private boolean inRange;
    private int range;
    /**
     *
     * @param x
     * @param y
     * @param dungeon
     * @param path
     */
    public Fireball(int x, int y, Dungeon dungeon, String path) {
        super(x, y, 10, 10, Color.RED, dungeon, path);
        inRange = true;
    }
    

   

    public void move(int direction) {
    switch (direction) {
      case 0 -> {
        // Mover hacia arriba
        y -= 10;
        if (y < 0 || y > getRange()) {
          inRange = false;
        }
        
      }
      case 1 -> {
        // Mover hacia abajo
        y += 10;
        if (y < 0 || y > getRange()) {
          inRange = false;
        }
        
      }
      case 2 -> {
        // Mover hacia la izquierda
        x -= 10;
        if (x < 0 || x > getRange()) {
          inRange = false;
        }
        
      }
      case 3 -> {
        // Mover hacia la derecha
        x += 10;
        if (x < 0 || x > getRange()) {
          inRange = false;
        }
        
      }
      default -> {
      }
    }
  }

    @Override
    public void draw(Graphics g) {
        ImageIcon image = new ImageIcon(getPath());
        if (image != null) {
            g.drawImage(image.getImage(), x, y,null);
        } else {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    
    
    
    

    // Aquí puedes agregar métodos para mover la bola de fuego, detectar colisiones, etc.

    /**
     *
     */
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(int range) {
        this.range = range;
    }

    
}
