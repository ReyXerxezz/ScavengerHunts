/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Creature.Unicorn;
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
public abstract class LivingBeing extends Sprite implements Drawable, Boundable{

    private Drawable drawable;
    private Boundable boundable;
    private int health;
    private int damage;
    private int range;
    private int speed;
    private ImageIcon image;
    private Dungeon dungeon;
    private boolean yUpMove;
    private boolean yDoMove;
    private boolean xRiMove;
    private boolean xLeMove;
    private int turnCounter;
    
    public LivingBeing(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image) {
        super(x, y, width, height, Color.BLUE);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.image = image; 
        yUpMove = false;
        yDoMove = false;
        xRiMove = false;
        xLeMove = false;
        turnCounter = 0;
    }
    
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public void setBoundable(Boundable boundable) {
        this.boundable = boundable;
    }
    public void actionHandle(int key, ArrayList<Wall> muros, ArrayList<LivingBeing> creatures){
        if(key == KeyEvent.VK_W |
           key == KeyEvent.VK_S |
           key == KeyEvent.VK_A |
           key == KeyEvent.VK_D)
            move(key, muros, creatures);
    }
    public boolean move(int key, ArrayList<Wall> muros, ArrayList<LivingBeing> creatures)
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
        for(Wall muro : muros){
            if(this.checkCollision(muro))
            {
                this.setX(xOriginal);
                this.setY(yOriginal);

                return false;
            }
        }
        int i = 0;
        for(LivingBeing monster : creatures){
            if(this.checkCollision(monster) && !(monster instanceof Unicorn))
            {
                this.setX(xOriginal);
                this.setY(yOriginal);
                
                return false;
            }
            else if (this.checkCollision(monster) && monster instanceof Unicorn){
                dungeon.eliminarCreature(i);
                System.out.println("TODO");
                return true;
            }
            i++;
        }
        
        return true;
    }
    
    public boolean verificarMove(ArrayList<Wall> muros, ArrayList<LivingBeing> creatures, LivingBeing arthur) {
        for (Wall muro : muros) {
            if (this.checkCollision(muro)) {
                return false;
            }
        }
        for (LivingBeing creature : creatures) {
            if (creature != this && this.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return false;
            }
        }
        if (this.checkCollision(arthur)) {
            return false;
        }

        return true;
    }
    public void moveCreature(Dungeon dungeon, ArrayList<Wall> muros, ArrayList<LivingBeing> creatures, LivingBeing arthur) {
        int xOriginal = x;
        int yOriginal = y;

        // Cambiar de dirección después de 10 vueltas del hilo
        if (turnCounter % 100 == 0) {
            changeDirection();
        }

        if (xLeMove) {
            x -= speed;
            if (!verificarMove(muros, creatures, arthur)) {
                x = xOriginal;
                changeDirection();
            }
        } else if (yUpMove) {
            y -= speed;
            if (!verificarMove(muros, creatures, arthur)) {
                y = yOriginal;
                changeDirection();
            }
        } else if (xRiMove) {
            x += speed;
            if (!verificarMove(muros, creatures, arthur)) {
                x = xOriginal;
                changeDirection();
            }
        } else if (yDoMove) {
            y += speed;
            if (!verificarMove(muros, creatures, arthur)) {
                y = yOriginal;
                changeDirection();
            }
        }

        turnCounter++;
    }
    
    private void changeDirection() {
        // Cambiar la dirección de manera aleatoria
        int randomDirection = (int) (Math.random() * 4);

        xLeMove = false;
        yUpMove = false;
        xRiMove = false;
        yDoMove = false;

        switch (randomDirection) {
            case 0:
                xLeMove = true;
                break;
            case 1:
                yUpMove = true;
                break;
            case 2:
                xRiMove = true;
                break;
            case 3:
                yDoMove = true;
                break;
        }
    }
    public void attack(Sprite sprite){
        
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
    

    @Override
    public void redraw() {
        getDrawable().redraw();
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

    /**
     * @return the boundable
     */
    public Boundable getBoundable() {
        return boundable;
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
