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
public class Barbarian extends Knight{
    
    public Barbarian(int x, int y, Dungeon dungeon) {
        super(x, y, 20, 30, 75, 100, 20, 5, new ImageIcon("BarbarianCharacter.png"), dungeon);
    }
    
}
