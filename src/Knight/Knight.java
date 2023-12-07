/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Boundable;
import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
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
    Weapon sword;
    
    public Knight(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image, Dungeon dungeon) {
        super(x, y, width, height, health, damage, range, speed, image, dungeon);
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
                getDungeon().eliminarCreature(i);
                int random = (int) (Math.random() * 2);
                int randomupgrade = (int) (Math.random() * 3);
                if(random == 0){
                    Upgrade u = new Upgrade(null, true);
                    u.setVisible(true);
                    switch (randomupgrade) {
                        case 0:
                            health=this.getHealth()+10;
                            JOptionPane.showMessageDialog(null, "Health Upgrade");
                            break;
                        case 1:
                            damage = this.getDamage()+10;
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
                            this.setHealth(this.getHealth()-10);
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
        
    }
    
    public int verificarAtaque(ArrayList<Monster> creatures, Espada espada){
        return 0;
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
    public Weapon getSword() {
        return sword;
    }

    /**
     * @return the dungeon
     */
    public Dungeon getDungeon() {
        return dungeon;
    }
    
}
