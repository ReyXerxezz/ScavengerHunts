/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class Escudo extends Weapon{

    public Escudo(int x, int y, int width, int height, Dungeon dungeon, String path) {
        super(x, y, width, height, Color.BLACK, dungeon, path);
    }

    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
