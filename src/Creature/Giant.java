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




public class Giant extends Monster{

    public static final int WIDTH = 25;

    /**
     *
     */
    public static final int HEIGHT = 31;

    /**
     *
     * @param x
     * @param y
     */
   
    public Giant(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 1000, 20, 10, 1, new ImageIcon("Giant.png"), dungeon);

    }

    /**
     *
     */
    @Override
    public void attack() {
        super.attack();
    }

    /**
     *
     * @return
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     *
     * @return
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

}
