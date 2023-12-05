/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.LivingBeing;
import Class.Sprite;
import static Creature.Basilisk.HEIGHT;
import static Creature.Basilisk.WIDTH;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Giant extends LivingBeing{
    public static final int WIDTH = 25;
    public static final int HEIGHT = 31;
    public Giant(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 1000, 50, 10, 1, new ImageIcon("Giant.png"));
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
