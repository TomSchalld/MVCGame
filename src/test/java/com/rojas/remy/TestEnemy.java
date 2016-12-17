package com.rojas.remy;

import com.rojas.remy.game.controller.Logic;
import com.rojas.remy.game.model.Model;
import com.rojas.remy.game.objects.Enemy;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by remy on 16/12/16.
 */
public class TestEnemy {

    Model model = new Model();
    @Test
    public void testEnemyPresence() {
        assertEquals(5,model.getEnemies().size());
    }

    @Test
    public void testMovement() {
        assertNotNull(model.getTimer());
        model.getEnemies().forEach(testEnemy -> {
            int enemyPos = testEnemy.getPosition().getxCoordinate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newEnemyPos = testEnemy.getPosition().getxCoordinate();
            assertNotEquals(enemyPos, newEnemyPos);
            //pause
            model.pause();
            enemyPos = testEnemy.getPosition().getxCoordinate();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newEnemyPos = testEnemy.getPosition().getxCoordinate();
            assertEquals(enemyPos, newEnemyPos);
            assertNull(model.getTimer());
            //resume
            model.loadMemento();
            enemyPos = testEnemy.getPosition().getxCoordinate();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newEnemyPos = testEnemy.getPosition().getxCoordinate();
            assertNotEquals(enemyPos, newEnemyPos);
            assertNotNull(model.getTimer());
        });
    }
}
