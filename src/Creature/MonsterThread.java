package Creature;

import Class.Dungeon;
import Class.LivingBeing;
import Class.Wall;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author santi
 */
public class MonsterThread extends Thread {

    private final Dungeon dungeon;
    private LivingBeing monster;
    private final int MOVE_INTERVAL = 10000; // Intervalo de movimiento en milisegundos

    public MonsterThread(Dungeon dungeon, LivingBeing monster) {
        this.dungeon = dungeon;
        this.monster = monster;
    }

    @Override
    public void run() {
        while (true) {
            long startTime = System.currentTimeMillis();

            monster.moveCreature(dungeon, dungeon.getMuros());

            // Check for collision with Arthur and perform attack
            if (monster.checkCollision(dungeon.getArthur())) {
                monster.attack(dungeon.getArthur());
            }

            // Redraw the game on the UI thread
            SwingUtilities.invokeLater(() -> {
                dungeon.getDrawable().redraw();
            });

            // Calcular el tiempo transcurrido y dormir para mantener el intervalo de movimiento
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = MOVE_INTERVAL - elapsedTime;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
