package com.rojas.remy.game.factory;

import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.objects.Enemy;
import com.rojas.remy.game.objects.GameObject;
import com.rojas.remy.game.model.Model;

import java.util.Random;

/**
 * Created by remy on 17/11/16.
 */
public class EnemyFactory extends ConcreteFactory {

    @Override
    public GameObject create() {
        Enemy e = new Enemy();
        e.setDrawable(drawable);
        e.setMovement(movement);
        e.setPosition(new TwoDimPosition(500,new Random().nextInt(500)));
        e.setImage(i);
        return e;
    }
}
