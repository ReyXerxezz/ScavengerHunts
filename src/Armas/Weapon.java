
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Class.Dungeon;
import Class.LivingBeing;
import Class.Sprite;
import Class.Wall;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * Arma que posee un personaje del juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public abstract class Weapon extends Sprite implements dungeons.gui.Drawable{
    private int direction; // Nueva propiedad para almacenar la dirección de movimiento
    private boolean expired;
    private Dungeon dungeon;
    private int damage;
    private LivingBeing shooter;
    private String path;
    private boolean inRange;
    /**
     * Constructor de la clase Weapon.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     * @param dungeon
     * @param image
     */
    public Weapon(int x, int y, int width, int height, Color color, Dungeon dungeon, String path) {
        super(x, y, width, height, color);
        this.direction = 0;
        this.expired = false;
        this.dungeon = dungeon;
        this.path = path;
        inRange = true;
    }

    public Weapon() {
        super(0, 0, 0, 0, null);
    }
    
     
    
    /**
     *
     * @param direction
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    @Override
    public void draw(Graphics g) {
        ImageIcon image = new ImageIcon(getPath());
        if (image != null) {
            g.drawImage(image.getImage(), x, y,null);
        } else {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    /**
     * Genera el movimiento de un arma para el ataque.
     */
    

    /**
     * Detecta la colisión de el arma con un muro o un monstruo.
     * @param target monstruo alcanzado por el Weapon.
     * @return Booleano que indica si hay colisióno no.
     */
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

    /**
     *
     * @return
     */
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

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }
    
    /**
     * @return the inRange
     */
    public boolean isInRange() {
        return inRange;
    }

    public void move(int i) {
        
    }
    
}

