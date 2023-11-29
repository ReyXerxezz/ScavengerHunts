/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public abstract class LivingBeing extends Sprite{

    private Drawable drawable;
    private Boundable boundable;
    private int health;
    private int damage;
    private int range;
    private int speed;
    //private ImageIcon image;
    
    public LivingBeing(int x, int y, int width, int height, int health, int damage, int range, int speed /*,ImageIcon image*/) {
        super(x, y, width, height, Color.BLUE);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        //this.image = image;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setBoundable(Boundable boundable) {
        this.boundable = boundable;
    }
    public void actionHandle(int key, ArrayList<Wall> Muros){
        if(key == KeyEvent.VK_W |
           key == KeyEvent.VK_S |
           key == KeyEvent.VK_A |
           key == KeyEvent.VK_D)
            move(key, Muros);
    }
    public boolean move(int key, ArrayList<Wall> Muros)
    {
        int xOriginal = x;
        int yOriginal = y;
        
        if(key == KeyEvent.VK_W)
            y -= speed;
        if(key == KeyEvent.VK_S)
            y += speed;
        if(key == KeyEvent.VK_A)
            x -= speed;
        if(key == KeyEvent.VK_D)
            x += speed;
        for(Wall muro : Muros){
            if(this.checkCollision(muro))
            {
                this.setX(xOriginal);
                this.setY(yOriginal);

                return false;
            }
        }
        
        return true;
    }
    public void attack(){
        
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
