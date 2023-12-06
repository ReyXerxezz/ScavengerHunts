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
    private int direction;
    private ArrayList<LivingBeing> targets = new ArrayList<>();
    
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
        this.direction =0;
    }
    
    /**
     *
     * @param drawable
     */
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    /**
     *
     * @param dungeon
     */
    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    /**
     *
     * @param boundable
     */
    public void setBoundable(Boundable boundable) {
        this.boundable = boundable;
    }

    /**
     * Maneja las acciones del teclado que generan el movimiento del LivingBeing.
     * @param key Numero que representa la tecla hundida.
     * @param muros Arreglo de muros del mapa.
     * @param creatures Arreglo de creaturas del mapa.
     */
    public void actionHandle(int key, ArrayList<Wall> muros, ArrayList<LivingBeing> creatures){
        if(key == KeyEvent.VK_W |
           key == KeyEvent.VK_S |
           key == KeyEvent.VK_A |
           key == KeyEvent.VK_D){
            setDirection(key);
            move(key, muros, creatures);
        }
        if(key == KeyEvent.VK_SPACE && (this instanceof Archer | this instanceof Magician | this instanceof Barbarian | this instanceof SwordMan | this instanceof Tank | this instanceof Assasin )){
            this.attack();
        }
    }

    /**
     * Genera el movimiento del LivingBeing a partir de las acciones de teclado.
     * @param key Numero que representa la tecla hundida.
     * @param muros Arreglo de muros del mapa.
     * @param creatures Arreglo de creaturas del mapa.
     * @return Booleano que indica si fue exitoso o no el movimiento.
     */
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
                int random = (int) (Math.random() * 2);
                int randomupgrade = (int) (Math.random() * 3);
                if(random == 0){
                    Upgrade u = new Upgrade(null, true);
                    u.setVisible(true);
                    switch (randomupgrade) {
                        case 0:
                            this.setHealth(getHealth()+20);
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
    
    /**
     * Verifica la validez del movimiento de un objeto en el mapa.
     * .
     * @param muros Arreglo de muros del mapa.
     * @param creatures Arreglo de creaturas del mapa.
     * @param arthur Personaje del usuario que se mueve en el mapa.
     * @return Booleano que indica si es válido el movimiento.
     */
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

    /**
     * Genera el movimiento de las creaturas que no maneja el usuario.
     * @param dungeon Mapa que se ha ejecutado.
     * @param muros Arreglo de muros del mapa.
     * @param creatures Arreglo de montruos del mapa.
     * @param arthur Personaje del usuario.
     */
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
    /**
     * Cambia la direccion de movimiento de un objeto.
     */
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

    /**
     *  Ataque de un LivingBeing
     */
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
    @Override
    public void redraw() {
        getDrawable().redraw();
    }
    
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
     * @return the boundable
     */
    public Boundable getBoundable() {
        return boundable;
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

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
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
    
    
}