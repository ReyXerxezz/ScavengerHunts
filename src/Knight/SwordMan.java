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
    
    /**
     *
     * @param x
     * @param y
     */
    public SwordMan(int x, int y, Dungeon dungeon) {
        super(x, y, 22, 25, 100, 62, 60, 8,new ImageIcon("SwordmanCharacter.png"), dungeon);
    }

    

    

}
