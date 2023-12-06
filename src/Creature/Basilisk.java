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
public class Basilisk extends Monster{
    public static final int WIDTH = 30;
    public static final int HEIGHT = 27;
    public Basilisk(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 600, 5, 10, 2, new ImageIcon("Basilisk.png"), dungeon);
    }

    @Override
    public void attack() {
        super.attack();
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
