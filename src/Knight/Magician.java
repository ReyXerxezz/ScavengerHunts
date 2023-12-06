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
    
<<<<<<< HEAD
    /**
     *
     * @param x
     * @param y
     */
    public Magician(int x, int y) {
        super(x, y, 16, 29, 15, 80, 100, 5, new ImageIcon("MagicianCharacter.png"));
=======
    public Magician(int x, int y, Dungeon dungeon) {
        super(x, y, 16, 29, 15, 80, 100, 5, new ImageIcon("MagicianCharacter.png"), dungeon);
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
    }
    
    /**
     *
     * @param sprite
     */
    public void attack(Sprite sprite) {
        Fireball fireball = new Fireball(x, y);
        fireballs.add(fireball);
    }
<<<<<<< HEAD

    /**
     *
     * @param sprite
     * @return
     */
    @Override
    public boolean isValid(Sprite sprite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
=======
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
}
