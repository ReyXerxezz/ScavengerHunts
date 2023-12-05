<<<<<<< HEAD
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
    public LivingBeing getMonster() {
        return monster;
    }
    
}
=======
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
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            getMonster().moveCreature(dungeon, dungeon.getMuros(), dungeon.getCreatures(), dungeon.getArthur());

            if (getMonster().checkCollision(dungeon.getArthur())) {
                getMonster().attack(dungeon.getArthur());
            }

            dungeon.getDrawable().redraw();
        }, 0, 20, TimeUnit.SECONDS); // Ajustado el intervalo a 5 segundos
    }

    /**
     * @return the monster
     */
    public LivingBeing getMonster() {
        return monster;
    }
    
}
>>>>>>> 42a8a16062c9192a5e28e79a92e44e02d316a1da
