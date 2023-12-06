/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Dungeon;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Assasin extends Knight{
    
<<<<<<< HEAD
    /**
     *
     * @param x
     * @param y
     */
    public Assasin(int x, int y) {
        super(x, y,20,28, 15, 175, 10, 10 , new ImageIcon("AssasinCharacter.png"));
    }

    /**
     *
     */
    @Override
    public void attack() {
        super.attack(); 
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
    public Assasin(int x, int y, Dungeon dungeon) {
        super(x, y,20,28, 15, 175, 10, 10 , new ImageIcon("AssasinCharacter.png"), dungeon);
    }
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
}
