
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

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
    
    /**
     *
     * @param x
     * @param y
     * @param arrowSpeed
     * @param arrowDamage
     */
    public Arrow(int x, int y, int arrowSpeed, int arrowDamage) {
        super(x, y, 22, 12, null, null, null);
        this.arrowSpeed = arrowSpeed;
        this.arrowDamage = arrowDamage;
        this.setDirection(0);
        this.image = new ImageIcon("Arrow.png");
    }
    
    /**
     *
     * @param targets
     */
    public void move(ArrayList<LivingBeing> targets) {
        // Mueve la flecha
        

        // Verifica colisiones con los objetivos
        for (LivingBeing target : targets) {
            if (checkCollision(target)) {
                // Realiza acciones en caso de colisión, como reducir la salud del objetivo, etc.
                target.setHealth(target.getHealth() - arrowDamage);
                setExpired(true);  // Marca la flecha como expirada después de colisionar
            }
        }
    }
    

    

    // Aquí puedes agregar métodos para mover la flecha, detectar colisiones, etc.

    @Override
    public void draw(Graphics g) {
        if (image != null) {
        g.drawImage(image.getImage(), x, y,null);
    } else {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

    /**
     *
     */
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
    }

    /**
     *
     * @param direction
     */
    @Override
    public void setDirection(int direction) {
        super.setDirection(direction);
    }

    /**
     * @return the dungeon
     */
    public Dungeon getDungeon() {
        return dungeon;
    }

    /**
     * @param dungeon the dungeon to set
     */
    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
}



