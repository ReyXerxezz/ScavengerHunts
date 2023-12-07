/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Acha;
import Armas.Fireball;
import Class.Dungeon;
import Armas.Fireball;
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
public class Magician extends Knight{
    private ArrayList<Fireball> fireballs = new ArrayList<>();
    
    /**
     *
     * @param x
     * @param y
     */
    

    public Magician(int x, int y, Dungeon dungeon) {
        super(x, y, 16, 29, 80, 80, 100, 5, new ImageIcon("MagicianCharacter.png"), dungeon);
    }
    
    public void attackArthur(ArrayList<Monster> creatures) {
    int ataque = -1;
    
    Fireball fireball = null;
    switch (getAtaqueDireccion()) {
      case 0 -> {
        fireball = new Fireball(x+(width/2),(y-17),getDungeon(), "fireball.png");
        while (fireball.isInRange()) {
          fireball.move(0);
          System.out.println(fireball.getX()+fireball.getY());
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
      }
      case 1 -> {
        fireball = new Fireball(x+(width/2), (y+height),getDungeon(), "fireball.png");
        while (fireball.isInRange()) {
          fireball.move(1);
          System.out.println(fireball.getX()+fireball.getY());
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
      }
      case 2 -> {
        fireball = new Fireball((x-9), y+(height/2), getDungeon(), "fireball.png");
        while (fireball.isInRange()) {
          fireball.move(2);
          System.out.println(fireball.getX()+fireball.getY());
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
      }
      case 3 -> {
        fireball = new Fireball((x+width), y+(height/2), getDungeon(), "fireball.png");
        while (fireball.isInRange()) {
          fireball.move(3);
            System.out.println(fireball.getX()+fireball.getY());
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            break;
          }
        }
      }
      default -> {
      }
    }
    fireballs.add(fireball);
  }
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Fireball fireball : fireballs) {
            fireball.draw(g);
        }
    }



}
