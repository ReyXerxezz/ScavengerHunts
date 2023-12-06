/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Class.Fireball;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Dragon extends Monster{
    private ArrayList<Fireball> fireballs;

    /**
     *
     */
    public static final int WIDTH = 200;

    /**
     *
     */
    public static final int HEIGHT = 229;
<<<<<<< HEAD

    /**
     *
     * @param x
     * @param y
     */
    public Dragon(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 3000, 100, 30, 1, new ImageIcon("Dragon.png"));
=======
    public Dragon(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 3000, 30, 30, 1, new ImageIcon("Dragon.png"), dungeon);
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
        fireballs = new ArrayList<>();
    }

    /**
     *
     */
    public void attack() {
        Fireball fireball = new Fireball(x, y);
        getFireballs().add(fireball);
    }
    

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        // Dibuja las bolas de fuego
        for (Fireball fireball : getFireballs()) {
            fireball.draw(g);
        }
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
    /**
     * @return the fireballs
     */
    public ArrayList<Fireball> getFireballs() {
        return fireballs;
    }
    
}
