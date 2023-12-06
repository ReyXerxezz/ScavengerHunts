/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Creature.Unicorn;
import Knight.Archer;
import Knight.Assasin;
import Knight.Barbarian;
import Knight.Magician;
import Knight.SwordMan;
import Knight.Tank;
import dungeons.gui.Downgrade;
import dungeons.gui.Drawable;
import dungeons.gui.Upgrade;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public abstract class LivingBeing extends Sprite{

    private Drawable drawable;
    private int health;
    private int damage;
    private int range;
    private int speed;
    private ImageIcon image;
    private Dungeon dungeon;
    
    public LivingBeing(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image, Dungeon dungeon) {
        super(x, y, width, height, Color.BLUE);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.image = image;
        this.dungeon = dungeon;
    }
    
    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    public void quitarVida(int daño){
        health = health - daño;
    }
    
    
    public void attack(){
    
    }
    
    
    @Override
    public void draw(Graphics g) {
        if (image != null) {
        g.drawImage(image.getImage(), x, y,null);
        } else {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    
    public void redraw(int x, int y, int width, int height) {
        getDrawable().redraw();
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param ataque
     */
    public void setHealth(int ataque) {
        this.health = health - ataque;
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

    /**
     * @return the drawable
     */
    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public int getX() {
        return super.getX(); 
    }

    @Override
    public int getY() {
        return super.getY(); 
    }
}