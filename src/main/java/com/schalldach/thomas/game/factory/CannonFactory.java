package com.schalldach.thomas.game.factory;

import com.schalldach.thomas.game.objects.Cannon;
import com.schalldach.thomas.game.objects.GameObject;

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
