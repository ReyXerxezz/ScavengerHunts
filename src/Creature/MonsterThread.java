/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Class.LivingBeing;
import Class.Wall;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class MonsterThread extends Thread {

    private final Dungeon dungeon;
    private LivingBeing monster;

    public MonsterThread(Dungeon dungeon, LivingBeing monster) {
        this.dungeon = dungeon;
        this.monster = monster;
    }

    @Override
    public void run() {
        while (true) {
            
            boolean movedSuccessfully = monster.moveCreature(dungeon,dungeon.getMuros(), dungeon.getCreatures());

            if (!movedSuccessfully) {
                continue;
            }

            if (monster.checkCollision(dungeon.getArthur())) {
                monster.attack(dungeon.getArthur());
            }

            // Simulate monster movement delay
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            dungeon.getDrawable().redraw();
        }
    }
}
 
    

    
