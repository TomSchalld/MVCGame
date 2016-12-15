package com.rojas.remy.game.factory;

import com.rojas.remy.game.objects.Cannon;
import com.rojas.remy.game.objects.GameObject;

/**
 * Created by remy on 17/11/16.
 */
public class CannonFactory extends ConcreteFactory{

    @Override
    public GameObject create() {
        Cannon c = new Cannon();
        c.setImage(i);
        c.setDrawable(drawable);
        c.setPosition(initPosition);
        c.setMovement(movement);

        return c;
    }
}
