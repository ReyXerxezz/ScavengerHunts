/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Daga;
import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
import Creature.Monster;
import Creature.Unicorn;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Assasin extends Knight{
    
    /**
     *
     * @param x
     * @param y
     */
     public Assasin(int x, int y, Dungeon dungeon) {
        super(x, y,20,28, 100, 175, 10, 10 , new ImageIcon("AssasinCharacter.png"), dungeon);
    }

    /**
     *
     */
    @Override
    public void attack() {
        super.attack(); 
    }
    
    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
        int ataque = -1;
        System.out.println("Espada1");
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Daga(x+(width/2),(y-17), 9, 17, getDungeon(), "daga1.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 1 -> {
                sword = new Daga(x+(width/2), (y+height), 9, 17, getDungeon(), "daga3.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 2 -> {
                sword = new Daga((x-9), y+(height/2), 17, 9, getDungeon(), "daga4.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 3 -> {
                sword = new Daga((x+width), y+(height/2), 17, 9, getDungeon(), "daga2.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            default -> {
            }
        }
    }
    
    public int verificarAtaque(ArrayList<Monster> creatures, Weapon espada){
        int i = 0;
        for (Monster creature : creatures) {
            if (espada.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
