package com.rojas.remy.game.factory;

import com.rojas.remy.game.helper.APosition;
import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.model.Config;
import com.rojas.remy.game.objects.Collision;
import com.rojas.remy.game.objects.GameObject;

/**
 * Created by remy on 17/11/16.
 */
public class CollisionFactory extends ConcreteFactory {

    @Override
    public GameObject create(){
        Collision c = new Collision();
        return c;
    }

    public GameObject create(TwoDimPosition p) {
        Collision c = new Collision();
        c.setDrawable(true);
        c.setImage(this.i);
        c.setPosition(p);
        c.setDecayTimer(200);
        return c;
    }
}
