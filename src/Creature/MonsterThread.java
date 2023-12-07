
package Creature;

import Class.Dungeon;
import Class.LivingBeing;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class MonsterThread extends Thread {

    private final Dungeon dungeon;
    private final Monster monster;

    /**
     *
     * @param dungeon
     * @param monster
     */
    
    public MonsterThread(Dungeon dungeon, Monster monster) {
        this.dungeon = dungeon;
        this.monster = monster;
    }

    /**
     *
     */
    @Override
    public void run() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            getMonster().moveCreature(dungeon, dungeon.getMuros(), dungeon.getCreatures(), dungeon.getArthur());

            if (getMonster().checkCollision(dungeon.getArthur())) {
                getMonster().attack();
            }

            dungeon.getDrawable().redraw();
        }, 0, 20, TimeUnit.SECONDS); // Ajustado el intervalo a 5 segundos
    }

    /**
     * @return the monster
     */
    public Monster getMonster() {
        return monster;
    }
    
}
