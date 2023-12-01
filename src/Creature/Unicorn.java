/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.LivingBeing;
import static Creature.Harpy.HEIGHT;
import static Creature.Harpy.WIDTH;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Unicorn extends LivingBeing{
    public static final int WIDTH = 25;
    public static final int HEIGHT = 25;
    public Unicorn(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 500, 80, 12, 7, new ImageIcon("Unicorn.png"));
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
