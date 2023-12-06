/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.LivingBeing;
import Class.Sprite;
import static Creature.Harpy.HEIGHT;
import static Creature.Harpy.WIDTH;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Unicorn extends LivingBeing{

    /**
     *
     */
    public static final int WIDTH = 25;

    /**
     *
     */
    public static final int HEIGHT = 25;

    /**
     *
     * @param x
     * @param y
     */
    public Unicorn(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 500, 80, 12, 0, new ImageIcon("Unicorn.png"));
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
