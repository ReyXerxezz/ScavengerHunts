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
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Magician extends Knight{
    private ArrayList<Fireball> fireballs = new ArrayList<>();
    
    /**
     *
     * @param x
     * @param y
     */
    

    public Magician(int x, int y, Dungeon dungeon) {
        super(x, y, 16, 29, 80, 80, 100, 5, new ImageIcon("MagicianCharacter.png"), dungeon);
    }
    
    /**
     *
     * @param sprite
     */
    public void attack(Sprite sprite) {
        Fireball fireball = new Fireball(x, y);
        fireballs.add(fireball);
    }

}
