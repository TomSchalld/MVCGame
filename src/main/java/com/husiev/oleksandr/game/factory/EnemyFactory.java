package com.husiev.oleksandr.game.factory;

import com.husiev.oleksandr.game.utils.TwoDimPosition;
import com.husiev.oleksandr.game.objects.Enemy;
import com.husiev.oleksandr.game.objects.EnemyState;
import com.husiev.oleksandr.game.objects.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Oleksandr on 17.11.2016.
 */
public class EnemyFactory extends ConcreteFactory{
    private List<Integer> windowSize;
    private EnemyState wakeState;

    @Override
    public GameObject create() {
        Enemy enemy = new Enemy();
        enemy.setImage(image);

        List<Double> vec = new ArrayList<Double>();
        vec.add((double)ThreadLocalRandom.current().nextInt(0, windowSize.get(0)));
        vec.add((double)ThreadLocalRandom.current().nextInt(200, windowSize.get(1)));
        initialPosition.addVector(vec);
        enemy.changePosition(new TwoDimPosition((TwoDimPosition) initialPosition));

        enemy.setEnemyState(wakeState);
        return enemy;
    }


    public void setWindowSize(List<Integer> windowSize) {
        this.windowSize = windowSize;
    }

    public void setWakeState(EnemyState wakeState) {
        this.wakeState = new EnemyState(wakeState);
    }

}
