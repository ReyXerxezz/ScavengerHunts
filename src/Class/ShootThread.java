/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Creature.Dragon;
import Creature.Monster;
import Knight.Archer;
import Knight.Magician;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class ShootThread extends Thread {

    private LivingBeing shooter; // The LivingBeing that is shooting
    private ArrayList<Monster> targets; // The list of targets that the projectiles can hit

    public ShootThread(LivingBeing shooter, ArrayList<Monster> targets) {
        this.shooter = shooter;
        this.targets = targets;
    }

    @Override
    public void run() {
        while (true) {
            // Create a new projectile
            Weapon projectile = createProjectile(shooter);

            // Move the projectile until it hits a target or disappears
            while (!projectile.isExpired()) {
                projectile.move();
                // Check for collisions with targets
                for (LivingBeing target : targets) {
                    if (projectile.checkCollision(target)) {
                        target.setHealth(target.getHealth() - shooter.getDamage());
                        projectile.setExpired(true);
                        break;
                    }
                }
            }

            // Wait a short period of time before creating another projectile
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Weapon createProjectile(LivingBeing shooter) {
        // Create a different type of projectile based on the shooter's class
        if (shooter instanceof Dragon) {
            return new Fireball(shooter.getX(), shooter.getY()+50);
        } else if (shooter instanceof Magician) {
            return new Fireball(shooter.getX(), shooter.getY()+5);
        } else if (shooter instanceof Archer) {
            return new Arrow(shooter.getX(), shooter.getY()+5, 5, shooter.getDamage());
        } else {
            return null;
        }
    }
}

