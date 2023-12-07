/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Arrow;
import Class.Dungeon;
import Class.LivingBeing;
import Class.Sprite;
import Creature.Monster;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Archer extends Knight {
    private ArrayList<Arrow> arrows = new ArrayList<>();
    

    /**
     *
     * @param x
     * @param y
     */
    
    public Archer(int x, int y, Dungeon dungeon) {
        super(x, y, 23, 28, 100, 40, 125, 10, new ImageIcon("ArcherCharacter.png"), dungeon);
    }
    /**
     *
     */
    


    
    
    public void attack(ArrayList<Monster> targets) {
        
     }
    @Override
    public void draw(Graphics g) {
        super.draw(g);

        // Dibuja las flechas
        
    }

}

