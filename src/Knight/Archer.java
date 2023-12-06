/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Arrow;
import Class.Dungeon;
import Class.LivingBeing;
import Class.Sprite;
import Creature.Monster;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Archer extends Knight {
    private ArrayList<Arrow> arrows = new ArrayList<>();
    
<<<<<<< HEAD
    /**
     *
     * @param x
     * @param y
     */
    public Archer(int x, int y) {
        super(x, y, 23, 28, 25, 40, 125, 10, new ImageIcon("ArcherCharacter.png"));
    }

    /**
     *
     */
    @Override
     public void attack() {
=======

    public Archer(int x, int y, Dungeon dungeon) {
        super(x, y, 23, 28, 25, 40, 125, 10, new ImageIcon("ArcherCharacter.png"), dungeon);
    }
    
    public void attack(ArrayList<Monster> targets) {
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
        // Crea una flecha y establece su posición inicial
        Arrow arrow = new Arrow(this.getX(), this.getY(), 5, this.getDamage());
        arrow.setShooter(this);
        
        // Ciclo para mover la flecha hasta que alcance su rango
        for (int i = 0; i < this.getRange(); i++) {
            arrow.move(targets); // Actualiza la posición de la flecha
            // Lógica para verificar colisiones con criaturas o muros si es necesario
            // (similar a la lógica que ya tienes para verificar colisiones en tu código)
            
            // Dibuja la flecha en la posición actual
            // (puedes hacer esto llamando a un método en tu objeto Dungeon que se encargue del dibujo)
        }
     }
    @Override
    public void draw(Graphics g) {
        super.draw(g);

        // Dibuja las flechas
        
    }
<<<<<<< HEAD

    /**
     *
     * @param sprite
     * @return
     */
    @Override
    public boolean isValid(Sprite sprite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return
     */
=======
    
>>>>>>> ce2e3393c3e96cb2dff5219b7fcc1801ccaf1e50
    @Override
    public int getAtaqueDireccion() {
        return super.getAtaqueDireccion(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}

