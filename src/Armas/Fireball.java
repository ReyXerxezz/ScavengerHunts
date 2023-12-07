/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
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
     * @param dungeon
     * @param path
     */
    public Fireball(int x, int y, Dungeon dungeon, String path) {
        super(x, y, 10, 10, Color.RED, dungeon, path);
    }
    

    

    

    // Aquí puedes agregar métodos para mover la bola de fuego, detectar colisiones, etc.

    /**
     *
     */
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
