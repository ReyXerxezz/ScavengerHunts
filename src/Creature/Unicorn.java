/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.LivingBeing;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Unicorn extends LivingBeing{
    
    public Unicorn(int x, int y, int width, int height, int health, int damage, int range, int speed) {
        super(x, y, width, height, health, damage, range, speed, new ImageIcon("Unicorn.png"));
    }
    
}
