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
public class Assasin extends Knight{
    
    public Assasin(int x, int y, Dungeon dungeon) {
        super(x, y,20,28, 15, 175, 10, 10 , new ImageIcon("AssasinCharacter.png"), dungeon);
    }
}
