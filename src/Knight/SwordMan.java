/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Dungeon;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class SwordMan extends Knight{
    
<<<<<<< HEAD
    /**
     *
     * @param x
     * @param y
     */
    public SwordMan(int x, int y) {
        super(x, y, 22, 25, 60, 62, 60, 8,new ImageIcon("SwordmanCharacter.png"));
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
    
=======
    public SwordMan(int x, int y, Dungeon dungeon) {
        super(x, y, 22, 25, 60, 62, 60, 8,new ImageIcon("SwordmanCharacter.png"), dungeon);
    }
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
}
