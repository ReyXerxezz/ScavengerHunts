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
public class Unicorn extends LivingBeing{

    /**
     *
     */
=======
public class Unicorn extends Monster{
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
    public static final int WIDTH = 25;

    /**
     *
     */
    public static final int HEIGHT = 25;
<<<<<<< HEAD

    /**
     *
     * @param x
     * @param y
     */
    public Unicorn(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 500, 80, 12, 0, new ImageIcon("Unicorn.png"));
=======
    public Unicorn(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 500, 80, 12, 0, new ImageIcon("Unicorn.png"), dungeon);
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
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
