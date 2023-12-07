/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Escudo;
import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
import Creature.Monster;
import Creature.Unicorn;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Tank extends Knight{
    
    /**
     *
     * @param x
     * @param y
     */
    public Tank(int x, int y, Dungeon dungeon) {
        super(x, y, 20, 30, 150, 32, 15, 3,new ImageIcon("TankCharacter1.png"), dungeon);
    }

    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
        int ataque = -1;
        System.out.println("Espada1");
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Escudo(x+(width/2),(y-17), 9, 17, getDungeon(), "escudo3.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 1 -> {
                sword = new Escudo(x+(width/2), (y+height), 9, 17, getDungeon(), "escudo1.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 2 -> {
                sword = new Escudo((x-9), y+(height/2), 17, 9, getDungeon(), "escudo2.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 3 -> {
                sword = new Escudo((x+width), y+(height/2), 17, 9, getDungeon(), "escudo4.png");
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
