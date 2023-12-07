/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Class.Dungeon;
import Class.LivingBeing;
import Class.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Espada extends Weapon{
    
    public Espada(int x, int y, int width, int height, Dungeon dungeon, String path) {
        super(x, y, width, height, Color.black, dungeon, path);
    }
    
    @Override
    public boolean checkCollision(Sprite sprite) {
        return super.checkCollision(sprite); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
