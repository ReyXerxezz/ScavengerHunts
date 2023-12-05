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
    private int ataqueDireccion;
    private ArrayList<LivingBeing> targets = new ArrayList<>();
    private Espada sword;
    
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
        ataqueDireccion = 0;
        sword = null;
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
           key == KeyEvent.VK_D){
            move(key, muros, creatures);
        }
        else if(key == KeyEvent.VK_SPACE){
            System.out.println("Ataque");
            attackArthur(creatures);
        }
    }
    public boolean move(int key, ArrayList<Wall> muros, ArrayList<LivingBeing> creatures)
    {
        int xOriginal = x;
        int yOriginal = y;
        
        if(key == KeyEvent.VK_W){
            sword = null;
            y -= speed;
            ataqueDireccion = 0;
        }
        if(key == KeyEvent.VK_S){
            sword = null;
            y += speed;
            ataqueDireccion = 1;
        }
        if(key == KeyEvent.VK_A){
            sword = null;
            x -= speed;
            ataqueDireccion = 2;
        }
        if(key == KeyEvent.VK_D){
            sword = null;
            x += speed;
            ataqueDireccion = 3;
        }
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
                int random = (int) (Math.random() * 2);
                int randomupgrade = (int) (Math.random() * 3);
                if(random == 0){
                    Upgrade u = new Upgrade(null, true);
                    u.setVisible(true);
                    switch (randomupgrade) {
                        case 0:
                            health= getHealth()+20;
                            JOptionPane.showMessageDialog(null, "Health Upgrade");
                            break;
                        case 1:
                            this.setDamage(getDamage()+20);
                            JOptionPane.showMessageDialog(null, "Damage Upgrade");
                            break;   
                        case 2:
                            this.setSpeed(getSpeed()+1);
                            JOptionPane.showMessageDialog(null, "Speed Upgrade");
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
                if(random == 1){
                    Downgrade d = new Downgrade(null, true);
                    d.setVisible(true);
                        switch (randomupgrade) {
                        case 0:
                            this.setHealth(getHealth()-10);
                            JOptionPane.showMessageDialog(null, "Health Downgrade");
                            break;
                        case 1:
                            this.setDamage(getDamage()-10);
                            JOptionPane.showMessageDialog(null, "Damage Downgrade");
                            break;   
                        case 2:
                            this.setSpeed(getSpeed()-1);
                            JOptionPane.showMessageDialog(null, "Speed Downgrade");
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
                System.out.println("TODO");
                return true;
            }
            i++;
        }
        
        return true;
    }
    
    public int verificarMove(ArrayList<Wall> muros, ArrayList<LivingBeing> creatures, LivingBeing arthur) {
        for (Wall muro : muros) {
            if (this.checkCollision(muro)) {
                return -1;
            }
        }
        for (LivingBeing creature : creatures) {
            if (creature != this && this.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return -1;
            }
        }
        if (this.checkCollision(arthur)) {
            return 0;
        }

        return 1;
    }
    
    public void quitarVida(int daño){
        health = health - daño;
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
            if (verificarMove(muros, creatures, arthur) == -1) {
                x = xOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                x = xOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(damage);
            }
        } else if (yUpMove) {
            y -= speed;
            if (verificarMove(muros, creatures, arthur) == -1) {
                y = yOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                y = yOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(damage);
            }
        } else if (xRiMove) {
            x += speed;
            if (verificarMove(muros, creatures, arthur) == -1) {
                x = xOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                x = xOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(damage);
            }
        } else if (yDoMove) {
            y += speed;
            if (verificarMove(muros, creatures, arthur) == -1) {
                y = yOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                y = yOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(damage);
            }
        }

        turnCounter++;
    }
    public void attack(){
    
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
    public void attackArthur(ArrayList<LivingBeing> creatures){
        int ataque = -1;
        System.out.println("Espada1");
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Espada(x+(width/2),(y-17), 9, 17);
                ataque = verificarAtaque(creatures, sword);
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            case 1 -> {
                sword = new Espada(x+(width/2), (y+height), 9, 17);
                ataque = verificarAtaque(creatures, sword);
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            case 2 -> {
                sword = new Espada((x-9), y+(height/2), 17, 9);
                ataque = verificarAtaque(creatures, sword);
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            case 3 -> {
                sword = new Espada((x+width), y+(height/2), 17, 9);
                ataque = verificarAtaque(creatures, sword);
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            default -> {
            }
        }
    }
    private int verificarAtaque(ArrayList<LivingBeing> creatures, Espada espada){
        int i = 0;
        for (LivingBeing creature : creatures) {
            if (espada.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return i;
            }
            i++;
        }
        return -1;
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

    /**
     * @return the targets
     */
    public ArrayList<LivingBeing> getTargets() {
        return targets;
    }

    /**
     * @param targets the targets to set
     */
    public void setTargets(ArrayList<LivingBeing> targets) {
        this.targets = targets;
    }

    /**
     * @return the sword
     */
    public Espada getSword() {
        return sword;
    }

    /**
     * @return the ataqueDireccion
     */
    public int getAtaqueDireccion() {
        return ataqueDireccion;
    }
    
    
}