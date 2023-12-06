/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Boundable;
import Class.Dungeon;
import Class.Espada;
import Class.LivingBeing;
import Class.Wall;
import Creature.Monster;
import Creature.Unicorn;
import dungeons.gui.Downgrade;
import dungeons.gui.Drawable;
import dungeons.gui.Upgrade;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Knight extends LivingBeing{
    
    private int health;
    private int damage;
    private int range;
    private int speed;
    private ImageIcon image;
    private Dungeon dungeon;
    private int ataqueDireccion;
    private Espada sword;
    
    public Knight(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image, Dungeon dungeon) {
        super(x, y, width, height, health, damage, range, speed, null, dungeon);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.image = image;
        this.dungeon = dungeon;
        ataqueDireccion = 0;
        this.sword = null;
    }
    
    public void actionHandle(int key, ArrayList<Wall> muros, ArrayList<Monster> creatures){
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
    
    public boolean move(int key, ArrayList<Wall> muros, ArrayList<Monster> creatures)
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
        for(Monster monster : creatures){
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
                            health= health+20;
                            JOptionPane.showMessageDialog(null, "Health Upgrade");
                            break;
                        case 1:
                            damage = damage+20;
                            JOptionPane.showMessageDialog(null, "Damage Upgrade");
                            break;   
                        case 2:
                            speed=speed+1;
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
                            this.setHealth(health-10);
                            JOptionPane.showMessageDialog(null, "Health Downgrade");
                            break;
                        case 1:
                            this.setDamage(damage-10);
                            JOptionPane.showMessageDialog(null, "Damage Downgrade");
                            break;   
                        case 2:
                            this.setSpeed(speed-1);
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
    
    public void attackArthur(ArrayList<Monster> creatures){
        int ataque = -1;
        System.out.println("Espada1");
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Espada(x+(width/2),(y-17), 9, 17);
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            case 1 -> {
                sword = new Espada(x+(width/2), (y+height), 9, 17);
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            case 2 -> {
                sword = new Espada((x-9), y+(height/2), 17, 9);
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            case 3 -> {
                sword = new Espada((x+width), y+(height/2), 17, 9);
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    dungeon.eliminarCreature(ataque);
                }
            }
            default -> {
            }
        }
    }
    
    private int verificarAtaque(ArrayList<Monster> creatures, Espada espada){
        int i = 0;
        for (LivingBeing creature : creatures) {
            if (espada.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * @return the ataqueDireccion
     */
    public int getAtaqueDireccion() {
        return ataqueDireccion;
    }

    /**
     * @return the sword
     */
    public Espada getSword() {
        return sword;
    }
    
}
