/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.LivingBeing;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class SwordMan extends LivingBeing{
    
    public SwordMan(int x, int y) {
        super(x, y, 15, 19, 60, 62, 60, 8,new ImageIcon("SwordmanCharacter.png"));
    }
    
}
