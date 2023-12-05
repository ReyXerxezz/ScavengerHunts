/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public abstract class Weapon extends Sprite implements dungeons.gui.Drawable{
    private int direction; // Nueva propiedad para almacenar la dirección de movimiento
    private boolean expired;
    private Dungeon dungeon;
    private int damage;
    private LivingBeing shooter;
    ImageIcon image;
    
    public Weapon(int x, int y, int width, int height, Color color, Dungeon dungeon, ImageIcon image) {
        super(x, y, width, height, color);
        this.direction = 0;
        this.expired = false;
        this.dungeon = dungeon;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    @Override
    public void draw(Graphics g) {
    }
    public void move() {
        // Mover la fireball en la dirección especificada
        switch (direction) {
            case KeyEvent.VK_W:
                y -= 5;
                shooter.redraw();
                break;
            case KeyEvent.VK_S:
                y += 5;
                shooter.redraw();
                break;
            case KeyEvent.VK_A:
                x -= 5;
                shooter.redraw();
                break;
            case KeyEvent.VK_D:
                x += 5;
                shooter.redraw();
                break;
            // Puedes agregar más casos según sea necesario
        }
    }
    public boolean checkCollision(LivingBeing target) {
        // Check for collisions with walls
        for (Wall wall : dungeon.getMuros()) {
            if (wall.checkCollision(this)) {
                setExpired(true);
                
                break;
            }
        }

        // Check for collisions with living beings
        if (target != null && target.checkCollision(this)) {
            target.setHealth(target.getHealth() - damage);
            setExpired(true);
            return true;
        }
        return false;
    }
    public boolean isExpired() {
    return expired;
    }

    /**
     * @param expired the expired to set
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * @param shooter the shooter to set
     */
    public void setShooter(LivingBeing shooter) {
        this.shooter = shooter;
    }

    
}
