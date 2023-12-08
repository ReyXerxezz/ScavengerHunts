
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
import Class.LivingBeing;
import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class Arrow extends Weapon {
    
    private boolean inRange;
    private int range;
    
    /**
     *
     * @param x
     * @param y
     * @param arrowSpeed
     * @param arrowDamage
     */
    public Arrow(int x, int y, Dungeon dungeon, String path) {
        super(x, y, 22, 12, Color.BLACK, dungeon, path);
        inRange = true;
    }
    
    /**
     *
     * @param targets
     */
    
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
        

        // Verifica colisiones con los objetivos

    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the inRange
     */
    public boolean isInRange() {
        return inRange;
    }

    /**
     * @return the range
     */
    public int getRange() {
        return range;
    }
    
        
    }

    




