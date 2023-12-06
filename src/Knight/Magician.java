/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Dungeon;
import Class.Fireball;
import Class.LivingBeing;
import Class.Sprite;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Magician extends Knight{
    private ArrayList<Fireball> fireballs = new ArrayList<>();
    
    public Magician(int x, int y, Dungeon dungeon) {
        super(x, y, 16, 29, 15, 80, 100, 5, new ImageIcon("MagicianCharacter.png"), dungeon);
    }
    
    public void attack(Sprite sprite) {
        Fireball fireball = new Fireball(x, y);
        fireballs.add(fireball);
    }
}
