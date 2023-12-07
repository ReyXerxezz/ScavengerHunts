/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Armas.Fireball;
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


    /**
     *
     * @param x
     * @param y
     */
    
    public Dragon(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 3000, 30, 30, 1, new ImageIcon("Dragon.png"), dungeon);
        fireballs = new ArrayList<>();
    }

    /**
     *
     */
    public void attack() {
        Fireball fireball = new Fireball(x, y, dungeon, "Fireball.png");
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

    /**
     * @return the fireballs
     */
    public ArrayList<Fireball> getFireballs() {
        return fireballs;
    }
    
}
