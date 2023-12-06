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
<<<<<<< HEAD
public class Demon extends LivingBeing{

    /**
     *
     */
=======
public class Demon extends Monster{
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
    public static final int WIDTH = 30;

    /**
     *
     */
    public static final int HEIGHT = 27;
    
<<<<<<< HEAD
    /**
     *
     * @param x
     * @param y
     */
    public Demon(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 650, 45, 10, 3, new ImageIcon("Demon.png"));
=======
    public Demon(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 650, 10, 10, 3, new ImageIcon("Demon.png"), dungeon);
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
    }

    /**
     *
     */
    @Override
    public void attack() {
        super.attack(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
<<<<<<< HEAD

    /**
     *
     * @param sprite
     * @return
     */
    @Override
    public boolean isValid(Sprite sprite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
=======
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
}
