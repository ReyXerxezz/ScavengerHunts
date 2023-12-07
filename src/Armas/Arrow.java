
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
import Class.LivingBeing;
import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class Arrow extends Weapon {
    
    private int arrowSpeed;
    private int arrowDamage;
    private Dungeon dungeon;
    private ImageIcon image;
    
    /**
     *
     * @param x
     * @param y
     * @param arrowSpeed
     * @param arrowDamage
     */
    public Arrow(int x, int y, Dungeon dungeon) {
        super(x, y, 22, 12, Color.BLACK, dungeon, "Arrow.png");
        this.arrowSpeed = arrowSpeed;
        this.arrowDamage = arrowDamage;
        this.setDirection(0);
        this.image = new ImageIcon(getPath());
    }
    
    /**
     *
     * @param targets
     */
    public void move(ArrayList<LivingBeing> targets) {
        while (true) {            
            for (LivingBeing target : targets) {
            if (checkCollision(target)) {
                // Realiza acciones en caso de colisión, como reducir la salud del objetivo, etc.
                dungeon.quitarVidaCreature(targets.indexOf(target), arrowDamage);
                setExpired(true);  // Marca la flecha como expirada después de colisionar
            }
        }
        }
        

        // Verifica colisiones con los objetivos
        
    }

    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



