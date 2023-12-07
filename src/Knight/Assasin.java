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
    
    /**
     *
     * @param x
     * @param y
     */
     public Assasin(int x, int y, Dungeon dungeon) {
        super(x, y,20,28, 100, 175, 10, 10 , new ImageIcon("AssasinCharacter.png"), dungeon);
    }

    /**
     *
     */
    @Override
    public void attack() {
        super.attack(); 
    }
    

   
}
