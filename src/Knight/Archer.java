/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Arrow;
import Class.LivingBeing;
import Class.Sprite;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jimenez
 * @author Daniel Felipe Lopez
 */
public class Archer extends LivingBeing {
    private ArrayList<Arrow> arrows = new ArrayList<>();

    public Archer(int x, int y) {
        super(x, y, 23, 28, 25, 40, 125, 10, new ImageIcon("ArcherCharacter.png"));
    }

    @Override
    public void attack(Sprite sprite) {
        Arrow arrow = new Arrow(x, y);
        arrows.add(arrow);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        // Dibuja las flechas
        for (Arrow arrow : arrows) {
            arrow.draw(g);
        }
    }

    @Override
    public boolean isValid(Sprite sprite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

