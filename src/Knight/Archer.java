/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Arrow;
import Class.LivingBeing;
import Class.Sprite;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Archer extends LivingBeing {
    private ArrayList<Arrow> arrows = new ArrayList<>();
    
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
        // Crea una flecha y establece su posición inicial
        Arrow arrow = new Arrow(this.getX(), this.getY(), 5, this.getDamage());
        arrow.setShooter(this);
        
        // Ciclo para mover la flecha hasta que alcance su rango
        for (int i = 0; i < this.getRange(); i++) {
            arrow.move(this.getTargets()); // Actualiza la posición de la flecha
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
    @Override
    public int getAtaqueDireccion() {
        return super.getAtaqueDireccion(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}

