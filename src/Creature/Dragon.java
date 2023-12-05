/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Fireball;
import Class.LivingBeing;
import Class.Sprite;
import Class.Wall;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Dragon extends LivingBeing{
    private ArrayList<Fireball> fireballs;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 229;
    public Dragon(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 3000, 100, 30, 1, new ImageIcon("Dragon.png"));
        fireballs = new ArrayList<>();
    }

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

    /**
     * @return the fireballs
     */
    public ArrayList<Fireball> getFireballs() {
        return fireballs;
    }
    
}
