/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Harpy extends Monster{
    public static final int WIDTH = 28;
    public static final int HEIGHT = 28;
    public Harpy(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 500, 15, 12, 4, new ImageIcon("Harpy.png"), dungeon);
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
