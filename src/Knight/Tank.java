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
public class Tank extends LivingBeing{
    
    public Tank(int x, int y) {
        super(x, y, 20, 25, 150, 32, 15, 3/*,new ImageIcon("Img/TankCharacter.png")*/);
    }
    
}
