/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.LivingBeing;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jimenez
 * @author Daniel Felipe Lopez
 */
public class Archer extends LivingBeing{
    
    public Archer(int x, int y) {
        super(x, y, 11, 18, 25, 40, 125, 10 , new ImageIcon("ArcherCharacter.png"));
    }
    
}
