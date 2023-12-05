package Creature;

import Class.Dungeon;
import Class.LivingBeing;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonsterThread extends Thread {

    private final Dungeon dungeon;
    private final LivingBeing monster;

    public MonsterThread(Dungeon dungeon, LivingBeing monster) {
        this.dungeon = dungeon;
        this.monster = monster;
    }

    @Override
    public void run() {
        
         getMonster().moveCreature(dungeon, dungeon.getMuros(), dungeon.getCreatures(), dungeon.getArthur());

            if (getMonster().checkCollision(dungeon.getArthur())) {
                getMonster().attack();
            }
            
            dungeon.getDrawable().redraw();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    /**
     * @return the monster
     */
    public LivingBeing getMonster() {
        return monster;
    }
    
}
