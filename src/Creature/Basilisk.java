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
    public static final int WIDTH = 30;
    public static final int HEIGHT = 27;
    public Basilisk(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 600, 40, 10, 4, new ImageIcon("Basilisk.png"));
    }

    @Override
    public void attack(Sprite sprite) {
        super.attack(sprite);
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
