/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Class.Sprite;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Unicorn extends Monster{
    public static final int WIDTH = 25;
    public static final int HEIGHT = 25;
    public Unicorn(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 500, 80, 12, 0, new ImageIcon("Unicorn.png"), dungeon);
    }

    
    
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }
    
}
