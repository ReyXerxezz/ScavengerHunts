/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.LivingBeing;
import Class.Sprite;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Basilisk extends LivingBeing{

    /**
     * Ancho del objeto basilisk.
     */
    public static final int WIDTH = 30;

    /**
     * Alto del objeto basilisk.
     */
    public static final int HEIGHT = 27;

    /**
     *
     * @param x
     * @param y
     */
    public Basilisk(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 600, 40, 10, 2, new ImageIcon("Basilisk.png"));
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

    /**
     *
     * @param sprite
     * @return
     */
    @Override
    public boolean isValid(Sprite sprite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
