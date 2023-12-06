/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.LivingBeing;
import Class.Sprite;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Barbarian extends LivingBeing{
    
    /**
     *
     * @param x
     * @param y
     */
    public Barbarian(int x, int y) {
        super(x, y, 20, 30, 75, 100, 20, 5, new ImageIcon("BarbarianCharacter.png"));
    }

    /**
     *
     * @param sprite
     * @return
     */
    @Override
    public boolean isValid(Sprite sprite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
