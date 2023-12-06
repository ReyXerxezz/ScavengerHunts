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
public class Demon extends Monster{
    public static final int WIDTH = 30;
    public static final int HEIGHT = 27;
    
    public Demon(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 650, 10, 10, 3, new ImageIcon("Demon.png"), dungeon);
    }

    @Override
    public void attack() {
        super.attack(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
