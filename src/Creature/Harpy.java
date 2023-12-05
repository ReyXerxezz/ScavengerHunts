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
public class Harpy extends LivingBeing{
    public static final int WIDTH = 28;
    public static final int HEIGHT = 28;
    public Harpy(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 500, 80, 12, 4, new ImageIcon("Harpy.png"));
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

    @Override
    public boolean isValid(Sprite sprite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
