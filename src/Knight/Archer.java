/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Arrow;
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
    

    /**
     *
     * @param x
     * @param y
     */
    
    public Archer(int x, int y, Dungeon dungeon) {
        super(x, y, 23, 28, 100, 40, 125, 10, new ImageIcon("ArcherCharacter.png"), dungeon);
    }
    /**
     *
     */
    
    

    
    
    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
    int ataque = -1;
    
    Arrow arrow = null;
    switch (getAtaqueDireccion()) {
      case 0 -> {
        arrow = new Arrow(x+(width/2),(y-17),getDungeon(), "Arrow1.png");
        getArrows().add(arrow);
        while (arrow.isInRange()) {
          arrow.move(0);
          
          dungeon.redraw();
          ataque = verificarAtaque(creatures, arrow);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
        getArrows().remove(arrow);
      }
      case 1 -> {
        arrow = new Arrow(x+(width/2), (y+height),getDungeon(), "Arrow3.png");
        getArrows().add(arrow);
        while (arrow.isInRange()) {
          arrow.move(1);
          
          dungeon.redraw();
          ataque = verificarAtaque(creatures, arrow);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
        getArrows().remove(arrow);
      }
      case 2 -> {
        arrow = new Arrow((x-9), y+(height/2), getDungeon(), "Arrow4.png");
        getArrows().add(arrow);
        while (arrow.isInRange()) {
          arrow.move(2);
          
          dungeon.redraw();
          ataque = verificarAtaque(creatures, arrow);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
        getArrows().remove(arrow);
      }
      case 3 -> {
        arrow = new Arrow((x+width), y+(height/2), getDungeon(), "Arrow2.png");
        getArrows().add(arrow);
        while (arrow.isInRange()) {
          arrow.move(3);
            
          dungeon.redraw();
          ataque = verificarAtaque(creatures, arrow);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
        getArrows().remove(arrow);
      }
      default -> {
      }
    }
        
  }
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        
    }

    public void attack(ArrayList<Monster> targets) {
    }
    

    /**
     * @return the arrows
     */
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }

    /**
     * @param arrows the arrows to set
     */
    public void setArrows(ArrayList<Arrow> arrows) {
        this.arrows = arrows;
    }

}

