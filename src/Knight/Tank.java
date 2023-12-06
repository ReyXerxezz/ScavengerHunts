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
public class Tank extends Knight{
    
    public Tank(int x, int y, Dungeon dungeon) {
        super(x, y, 20, 30, 150, 32, 15, 3,new ImageIcon("TankCharacter1.png"), dungeon);
    }
}
