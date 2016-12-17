package com.rojas.remy.game.factory;

import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.objects.Brick;
import com.rojas.remy.game.objects.GameObject;

/**
 * Created by remy on 16/12/16.
 */
public class BrickFactory extends ConcreteFactory{

    @Override
    public GameObject create() {
        return null;
    }

    public GameObject create(TwoDimPosition pos){
        Brick b = new Brick();
        b.setPosition(pos);
        b.setDrawable(true);
        b.setImage(i);
        return b;
    }
}
