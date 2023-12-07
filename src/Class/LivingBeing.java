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
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public abstract class LivingBeing extends Sprite{

    private Drawable drawable;
    private int health;
    private int damage;
    private int range;
    private int speed;
    private ImageIcon image;
    private Dungeon dungeon;
    

    /**
     *  Constructor que crea instancias de la clase LivingBeing.
     * @param x posicion en x del Livingbeing
     * @param y posicion en y del Livingbeing
     * @param width ancho del Livingbeing
     * @param height alto del Livingbeing
     * @param health Vida del Livingbeing
     * @param damage Daño que genera el Livingbeing
     * @param range Rango de ataque del Livingbeing
     * @param speed Velocidad de movimiento del Livingbeing
     * @param image Imagen que representa el Livingbeing
     */
   

    public LivingBeing(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image, Dungeon dungeon) {
        super(x, y, width, height, Color.BLUE);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.image = image; 
        
    }
    
    /**
     *
     * @param drawable
     */
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        this.image = image;
        this.dungeon = dungeon;
    }
    
    /**
     *
     * @param dungeon
     */
    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }



    public void quitarVida(int daño){
        health = health - daño;
    }

    public void attack(){
    
    }

    
    /**
     * Dibuja la imagen que representa el LivingBeing.
     * @param g 
     */
    
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
     * Redibuja el LivingBeing
     */
    
    
    /**
     * Redibuja de acuerdo a los parametros básicos del objeto.
     * @param x
     * @param y
     * @param width
     * @param height
     */
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

   

    /**
     *
     * @return
     */
    @Override
    public int getX() {
        return super.getX(); 
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        return super.getY(); 
    }
}
