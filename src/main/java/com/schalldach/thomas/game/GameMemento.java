package com.schalldach.thomas.game;

import com.schalldach.thomas.game.helper.Score;
import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.Collision;
import com.schalldach.thomas.game.objects.Enemy;
import com.schalldach.thomas.game.objects.Missile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class GameMemento {

    private final int missileIndicator;
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private List<Collision> collisions;
    private final Score score;
    private boolean gameEnd = false;


    public GameMemento(Model game) {
        missileIndicator = game.getMissileIndicator();
        saveEnemies(game);
        saveMissiles(game);
        saveCollisions(game);
        this.score = new Score(game.getScore());
        this.gameEnd = game.isGameEnd();
    }

    private void saveCollisions(Model game) {
        this.collisions = new ArrayList<>();
        game.getCollisions().forEach(collision -> {
            try {
                collisions.add(collision.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
    }

    private void saveMissiles(Model game) {
        this.missiles = new ArrayList<>();
        game.getMissiles().forEach(missile -> {
            try {
                missiles.add(missile.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
    }

    private void saveEnemies(Model game) {
        this.enemies = new ArrayList<>();
        game.getEnemies().forEach(enemy -> {
            try {
                enemies.add(enemy.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
    }

    public int getMissileIndicator() {
        return missileIndicator;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public List<Collision> getCollisions() {
        return collisions;
    }

    public Score getScore() {
        return score;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }
}
