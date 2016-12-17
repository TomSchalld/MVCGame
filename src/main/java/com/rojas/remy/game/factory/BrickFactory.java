package com.rojas.remy.game.factory;

import com.rojas.remy.game.helper.TwoDimPosition;
import com.rojas.remy.game.objects.Brick;
import com.rojas.remy.game.objects.GameObject;

/**
 * Created by remy on 16/12/16.
 */
public class BrickFactory extends ConcreteFactory{

    private int health;

    public BrickFactory(){
        health = 4;
    }

    @Override
    public GameObject create() {
        return null;
    }

    public GameObject create(TwoDimPosition pos){
        Brick b = new Brick(health);
        b.setPosition(pos);
        b.setDrawable(true);
        b.setImage(i);
        return b;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
