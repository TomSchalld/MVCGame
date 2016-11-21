package com.schalldach.thomas.game.threads;

import com.schalldach.thomas.game.objects.Enemy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 17/11/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class EnemyMovementThread implements Runnable {

    private List<Enemy> enemies;

    public EnemyMovementThread(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    private void moveThemAll() {

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).move();
            if (!enemies.get(i).isPositionValid()) {
                enemies.get(i).move(Arrays.asList(1080.0, enemies.get(i).getPosition().getVector().get(1)));
            }
        }

    }

    @Override
    public void run() {

        while (true) {
            this.moveThemAll();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }


    }
}
